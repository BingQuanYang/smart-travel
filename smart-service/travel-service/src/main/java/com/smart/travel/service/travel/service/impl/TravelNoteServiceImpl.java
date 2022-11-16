package com.smart.travel.service.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.common.core.result.ResultCode;
import com.smart.travel.common.core.utils.BeanCopyUtils;
import com.smart.travel.service.travel.dto.TravelNoteDTO;
import com.smart.travel.service.travel.entity.TravelNote;
import com.smart.travel.service.travel.mapper.TravelNoteMapper;
import com.smart.travel.service.travel.service.TravelNoteService;
import com.smart.travel.service.travel.vo.TravelNoteVO;
import com.smart.travel.service.user.feign.service.UserService;
import com.smart.travel.service.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ybq
 */
@Service
@Slf4j
public class TravelNoteServiceImpl implements TravelNoteService {

    @Resource
    TravelNoteMapper travelNoteMapper;

    @Resource
    UserService userService;

    @Override
    public TravelNoteVO getById(Long id) throws BaseException {
        TravelNoteVO travelNoteVO = null;
        TravelNote travelNote = travelNoteMapper.selectById(id);
        if (travelNote == null) {
            log.error("根据ID查询游记信息失败：{}", id);
            throw new BaseException(ResultCode.ERROR.getStatus(), "根据ID查询游记信息失败");
        }
        travelNoteVO = new TravelNoteVO();
        BeanUtils.copyProperties(travelNote, travelNoteVO);
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
        BaseResult<UserVO> byId = userService.getById(travelNoteVO.getUserId());
        if (BaseResult.isSuccess(byId)) {
            UserVO userVO = byId.getData();
            travelNoteVO.setNickname(userVO.getNickname());
            travelNoteVO.setUserImage(userVO.getImage());
        }
        return travelNoteVO;
    }

    @Override
    public PageResult<TravelNoteVO> list(Long page, Long size) throws BaseException {
        PageResult<TravelNoteVO> pageResult = new PageResult<>();
        try {
            Page<TravelNote> strategyPage = new Page<>(page, size);
            Page<TravelNote> selectPage = travelNoteMapper.selectPage(strategyPage, new QueryWrapper<>());
            pageResult.setPage(selectPage.getCurrent());
            pageResult.setPageSize(size);
            pageResult.setTotalCount(selectPage.getTotal());
            pageResult.setPages(selectPage.getPages());

            List<TravelNote> records = strategyPage.getRecords();
            List<TravelNoteVO> travelNoteVOList = BeanCopyUtils.copyListProperties(records, TravelNoteVO::new);


            travelNoteVOList.forEach(travelNoteVO -> {
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
            });


            Map<Long, UserVO> userVOMap = new HashMap<>();
            travelNoteVOList.forEach(travelNoteVO -> {
                Long userId = travelNoteVO.getUserId();
                UserVO userVO = userVOMap.get(userId);
                if (userVO == null) {
                    BaseResult<UserVO> byId = userService.getById(userId);
                    if (BaseResult.isSuccess(byId)) {
                        userVO = byId.getData();
                        travelNoteVO.setNickname(userVO.getNickname());
                        travelNoteVO.setUserImage(userVO.getImage());
                        userVOMap.put(userId, userVO);
                    }
                } else {
                    travelNoteVO.setNickname(userVO.getNickname());
                    travelNoteVO.setUserImage(userVO.getImage());
                }
            });
            pageResult.setList(travelNoteVOList);
        } catch (Exception e) {
            log.error("获取游记列表失败：{}", page);
            throw new BaseException(ResultCode.ERROR.getStatus(), "获取攻略列表失败");
        }
        return pageResult;
    }

    @Override
    public PageResult<TravelNoteVO> listByUserId(Long userId, Long page, Long size) throws BaseException {
        PageResult<TravelNoteVO> pageResult = new PageResult<>();
        try {
            Page<TravelNote> strategyPage = new Page<>(page, size);
            Page<TravelNote> selectPage = travelNoteMapper.selectPage(strategyPage, new QueryWrapper<TravelNote>().lambda().eq(TravelNote::getUserId, userId));

            pageResult.setPage(selectPage.getCurrent());
            pageResult.setPageSize(size);
            pageResult.setTotalCount(selectPage.getTotal());
            pageResult.setPages(selectPage.getPages());

            List<TravelNote> records = strategyPage.getRecords();
            List<TravelNoteVO> travelNoteVOList = BeanCopyUtils.copyListProperties(records, TravelNoteVO::new);

            travelNoteVOList.forEach(travelNoteVO -> {
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
            });


            BaseResult<UserVO> byId = userService.getById(userId);
            if (BaseResult.isSuccess(byId)) {
                UserVO userVO = byId.getData();
                travelNoteVOList.forEach(travelNoteVO -> {
                    travelNoteVO.setNickname(userVO.getNickname());
                    travelNoteVO.setUserImage(userVO.getImage());
                });
            }
            pageResult.setList(travelNoteVOList);
        } catch (Exception e) {
            log.error("根据用户ID获游记略列表失败：{}->{}", userId, page);
            throw new BaseException(ResultCode.ERROR.getStatus(), "根据用户ID获取攻略列表失败");
        }
        return pageResult;
    }

    @Override
    public TravelNoteVO add(TravelNoteDTO travelNoteDTO) throws BaseException {
        TravelNote travelNote = new TravelNote();
        BeanUtils.copyProperties(travelNoteDTO, travelNote);
        int insert = travelNoteMapper.insert(travelNote);
        if (insert < 1) {
            log.error("添加游失败：{}", travelNoteDTO);
            throw new BaseException(ResultCode.ERROR);
        }

        TravelNoteVO travelNoteVO = getTravelNoteVO(travelNote);
        return travelNoteVO;
    }

    private TravelNoteVO getTravelNoteVO(TravelNote travelNote) {
        TravelNoteVO travelNoteVO = new TravelNoteVO();
        BeanUtils.copyProperties(travelNote, travelNoteVO);
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
        BaseResult<UserVO> byId = userService.getById(travelNoteVO.getUserId());
        if (BaseResult.isSuccess(byId)) {
            UserVO userVO = byId.getData();
            travelNoteVO.setNickname(userVO.getNickname());
            travelNoteVO.setUserImage(userVO.getImage());
        }
        return travelNoteVO;
    }
}
