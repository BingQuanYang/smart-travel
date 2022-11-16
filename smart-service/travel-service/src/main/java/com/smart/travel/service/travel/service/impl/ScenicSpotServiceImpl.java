package com.smart.travel.service.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.common.core.result.ResultCode;
import com.smart.travel.common.core.utils.BeanCopyUtils;
import com.smart.travel.service.travel.entity.ScenicSpot;
import com.smart.travel.service.travel.entity.Strategy;
import com.smart.travel.service.travel.mapper.ScenicSpotMapper;
import com.smart.travel.service.travel.service.ScenicSpotService;
import com.smart.travel.service.travel.service.StrategyService;
import com.smart.travel.service.travel.service.TravelNoteService;
import com.smart.travel.service.travel.vo.*;
import com.smart.travel.service.user.feign.service.UserService;
import com.smart.travel.service.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ybq
 */
@Service
@Slf4j
public class ScenicSpotServiceImpl implements ScenicSpotService {
    @Resource
    ScenicSpotMapper scenicSpotMapper;

    @Resource
    UserService userService;

    @Resource
    StrategyService strategyService;

    @Resource
    TravelNoteService travelNoteService;

    @Override
    public TravelDetailVO getThreeById(long id) throws BaseException {
        TravelDetailVO travelDetailVO = null;
        try {
            ScenicSpot scenicSpot = scenicSpotMapper.getThreeById(id);
            travelDetailVO = new TravelDetailVO();
            BeanUtils.copyProperties(scenicSpot, travelDetailVO);
            //景点介绍
            ScenicSpotIntroductionVO scenicSpotIntroductionVO = new ScenicSpotIntroductionVO();
            BeanUtils.copyProperties(scenicSpot.getScenicSpotIntroduction(), scenicSpotIntroductionVO);
            travelDetailVO.setScenicSpotIntroductionVO(scenicSpotIntroductionVO);
            //景点图片
            if (StringUtils.isNotBlank(scenicSpot.getImages())) {
                String[] split = scenicSpot.getImages().split(";");
                List<String> imageList = Arrays.stream(split).collect(Collectors.toList());
                travelDetailVO.setImagesList(imageList);
            }
            //景点标签
            if (StringUtils.isNotBlank(scenicSpot.getTitle())) {
                String[] split = scenicSpot.getTitle().split(";");
                List<String> titleList = Arrays.stream(split).collect(Collectors.toList());
                travelDetailVO.setTitleList(titleList);
            }

            Map<Long, UserVO> userVOMap = new HashMap<>();

            //攻略
            List<StrategyVO> strategyVOList = BeanCopyUtils.copyListProperties(scenicSpot.getStrategyList(), StrategyVO::new);
            for (StrategyVO strategyVO : strategyVOList) {
                UserVO userVO = userVOMap.get(strategyVO.getUserId());
                if (userVO != null) {
                    strategyVO.setNickname(userVO.getNickname());
                    strategyVO.setImage(userVO.getImage());
                } else {
                    BaseResult<UserVO> byId = userService.getById(strategyVO.getUserId());
                    if (BaseResult.isSuccess(byId)) {
                        userVO = byId.getData();
                        strategyVO.setNickname(userVO.getNickname());
                        strategyVO.setImage(userVO.getImage());
                        userVOMap.put(userVO.getUserId(), userVO);
                    }
                }
            }
            travelDetailVO.setStrategyVOList(strategyVOList);

            //游记
            List<TravelNoteVO> travelNoteVOList = BeanCopyUtils.copyListProperties(scenicSpot.getTravelNoteList(), TravelNoteVO::new);
            for (TravelNoteVO travelNoteVO : travelNoteVOList) {
                //图片
                if (StringUtils.isNotBlank(travelNoteVO.getImages())) {
                    String[] split = travelNoteVO.getImages().split(";");
                    List<String> imageList = Arrays.stream(split).collect(Collectors.toList());
                    travelNoteVO.setImageList(imageList);
                    if (imageList.size() >= 1) {
                        travelNoteVO.setImages(imageList.get(0));
                    }
                }
                //内容
                if (StringUtils.isNotBlank(travelNoteVO.getContent())) {
                    String[] split = travelNoteVO.getContent().split("<br>");
                    List<String> contentList = Arrays.stream(split).collect(Collectors.toList());
                    travelNoteVO.setContentList(contentList);
                }
                //用户信息
                UserVO userVO = userVOMap.get(travelNoteVO.getUserId());
                if (userVO != null) {
                    travelNoteVO.setNickname(userVO.getNickname());
                    travelNoteVO.setUserImage(userVO.getImage());
                } else {
                    BaseResult<UserVO> byId = userService.getById(travelNoteVO.getUserId());
                    if (BaseResult.isSuccess(byId)) {
                        userVO = byId.getData();
                        travelNoteVO.setNickname(userVO.getNickname());
                        travelNoteVO.setUserImage(userVO.getImage());
                        userVOMap.put(userVO.getUserId(), userVO);
                    }
                }
            }
            travelDetailVO.setTravelNoteVOList(travelNoteVOList);
        } catch (Exception e) {
            log.error("获取旅游详情失败");
            throw new BaseException(ResultCode.ERROR.getStatus(), "获取旅游详情失败");
        }
        return travelDetailVO;
    }


    @Override
    public PageResult<ScenicSpotVO> list(Long page, Long size) {
        PageResult<ScenicSpotVO> pageResult = new PageResult<>();
        Page<ScenicSpot> scenicSpotPage = new Page<>(page, size);
        Page<ScenicSpot> selectPage = scenicSpotMapper.selectPage(scenicSpotPage, new QueryWrapper<ScenicSpot>());

        pageResult.setPage(selectPage.getCurrent());
        pageResult.setPageSize(size);
        pageResult.setTotalCount(selectPage.getTotal());
        pageResult.setPages(selectPage.getPages());
        List<ScenicSpot> scenicSpotList = selectPage.getRecords();
        List<ScenicSpotVO> scenicSpotVOList = BeanCopyUtils.copyListProperties(scenicSpotList, ScenicSpotVO::new);
        scenicSpotVOList.forEach(scenicSpotVO -> {
            String[] split = scenicSpotVO.getImages().split(";");
            List<String> stringList = Arrays.stream(split).collect(Collectors.toList());
            scenicSpotVO.setImageList(stringList);
            if (stringList.size() >= 1) {
                scenicSpotVO.setImages(stringList.get(0));
            }

        });
        pageResult.setList(scenicSpotVOList);
        return pageResult;
    }

    @Override
    public MineVO mine(Long userId) throws BaseException {
        MineVO mineVO = new MineVO();
        try {
            PageResult<StrategyVO> pageResult = strategyService.listByUserId(userId, 1L, 1L);
            List<StrategyVO> list = pageResult.getList();
            if(list.size()>0){
                StrategyVO strategyVO = list.get(0);
                mineVO.setStrategyVO(strategyVO);
            }
            PageResult<TravelNoteVO> travelNoteVOPageResult = travelNoteService.listByUserId(userId, 1L, 3L);
            mineVO.setTravelNoteVOList(travelNoteVOPageResult.getList());
        } catch (Exception e) {
            log.error("获取我的页面数据失败");
            e.printStackTrace();
            throw new BaseException(ResultCode.ERROR.getStatus(), "获取我的页面数据失败");
        }
        return mineVO;
    }

    @Override
    public NavStrategyVO strategy() throws BaseException {
        PageResult<StrategyVO> strategyVOPageResult = strategyService.list(1L, 5L);
        PageResult<TravelNoteVO> travelNoteVOPageResult = travelNoteService.list(1L, 8L);
        NavStrategyVO navStrategyVO = new NavStrategyVO();
        navStrategyVO.setStrategyVOList(strategyVOPageResult.getList());
        navStrategyVO.setTravelNoteVOList(travelNoteVOPageResult.getList());
        return navStrategyVO;
    }

    @Override
    public HomeVO index() throws BaseException {
        try {
            HomeVO homeVO = new HomeVO();
            homeVO.setNavScenicSpotList(list(1L, 4L).getList());
            homeVO.setWeekScenicSpotList(list(1L, 3L).getList());
            homeVO.setTitleScenicSpotList(list(2L, 6L).getList());
            homeVO.setTravelNoteVOList(travelNoteService.list(1L, 8L).getList());
            return homeVO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ResultCode.ERROR);
        }
    }
}
