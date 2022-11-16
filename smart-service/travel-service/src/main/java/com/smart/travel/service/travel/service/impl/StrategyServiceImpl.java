package com.smart.travel.service.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.common.core.result.ResultCode;
import com.smart.travel.common.core.utils.BeanCopyUtils;
import com.smart.travel.service.travel.dto.StrategyDTO;
import com.smart.travel.service.travel.entity.Strategy;
import com.smart.travel.service.travel.mapper.StrategyMapper;
import com.smart.travel.service.travel.service.StrategyService;
import com.smart.travel.service.travel.vo.NavStrategyVO;
import com.smart.travel.service.travel.vo.StrategyVO;
import com.smart.travel.service.travel.vo.TravelNoteVO;
import com.smart.travel.service.user.feign.service.UserService;
import com.smart.travel.service.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ybq
 */
@Service
@Slf4j
public class StrategyServiceImpl implements StrategyService {
    @Resource
    StrategyMapper strategyMapper;

    @Resource
    UserService userService;

    @Override
    public StrategyVO getById(Long id) throws BaseException {
        Strategy strategy = strategyMapper.selectById(id);
        if (strategy == null) {
            log.error("根据ID查询攻略信息失败：{}", id);
            throw new BaseException(ResultCode.ERROR.getStatus(), "根据ID查询攻略信息失败");
        }
        StrategyVO strategyVO = strategytoStrategyVO(strategy);
        return strategyVO;
    }


    @Override
    public PageResult<StrategyVO> list(Long page, Long size) throws BaseException {
        PageResult<StrategyVO> pageResult = new PageResult<>();
        try {
            Page<Strategy> strategyPage = new Page<>(page, size);
            Page<Strategy> selectPage = strategyMapper.selectPage(strategyPage, new QueryWrapper<>());
            pageResult.setPage(selectPage.getCurrent());
            pageResult.setPageSize(size);
            pageResult.setTotalCount(selectPage.getTotal());
            pageResult.setPages(selectPage.getPages());

            List<Strategy> records = strategyPage.getRecords();
            List<StrategyVO> strategyVOList = BeanCopyUtils.copyListProperties(records, StrategyVO::new);

            Map<Long, UserVO> userVOMap = new HashMap<>();
            strategyVOList.forEach(strategyVO -> {
                Long userId = strategyVO.getUserId();
                UserVO userVO = userVOMap.get(userId);
                if (userVO == null) {
                    BaseResult<UserVO> byId = userService.getById(userId);
                    if (BaseResult.isSuccess(byId)) {
                        userVO = byId.getData();
                        strategyVO.setNickname(userVO.getNickname());
                        strategyVO.setImage(userVO.getImage());
                        userVOMap.put(userId, userVO);
                    }
                } else {
                    strategyVO.setNickname(userVO.getNickname());
                    strategyVO.setImage(userVO.getImage());
                }
            });
            pageResult.setList(strategyVOList);
        } catch (Exception e) {
            log.error("获取攻略列表失败：{}", page);
            throw new BaseException(ResultCode.ERROR.getStatus(), "获取攻略列表失败");
        }
        return pageResult;
    }

    @Override
    public PageResult<StrategyVO> listByUserId(Long userId, Long page, Long size) throws BaseException {
        PageResult<StrategyVO> pageResult = new PageResult<>();
        try {
            Page<Strategy> strategyPage = new Page<>(page, size);
            Page<Strategy> selectPage = strategyMapper.selectPage(strategyPage, new QueryWrapper<Strategy>().lambda().eq(Strategy::getUserId, userId));

            pageResult.setPage(selectPage.getCurrent());
            pageResult.setPageSize(size);
            pageResult.setTotalCount(selectPage.getTotal());
            pageResult.setPages(selectPage.getPages());

            List<Strategy> records = strategyPage.getRecords();
            List<StrategyVO> strategyVOList = BeanCopyUtils.copyListProperties(records, StrategyVO::new);

            BaseResult<UserVO> byId = userService.getById(userId);
            if (BaseResult.isSuccess(byId)) {
                UserVO userVO = byId.getData();
                strategyVOList.forEach(strategyVO -> {
                    strategyVO.setNickname(userVO.getNickname());
                    strategyVO.setImage(userVO.getImage());
                });
            }
            pageResult.setList(strategyVOList);
        } catch (Exception e) {
            log.error("根据用户ID获取攻略列表失败：{}->{}", userId, page);
            throw new BaseException(ResultCode.ERROR.getStatus(), "根据用户ID获取攻略列表失败");
        }
        return pageResult;
    }


    @Override
    public StrategyVO getByUserId(Long userId) {
        Strategy strategy = strategyMapper.selectOne(new QueryWrapper<Strategy>().lambda().eq(Strategy::getUserId, userId).orderByDesc(Strategy::getCreateTime));
        StrategyVO strategyVO = strategytoStrategyVO(strategy);
        return strategyVO;
    }


    private StrategyVO strategytoStrategyVO(Strategy strategy) {
        StrategyVO strategyVO = new StrategyVO();
        BeanUtils.copyProperties(strategy, strategyVO);
        BaseResult<UserVO> byId = userService.getById(strategyVO.getUserId());
        if (BaseResult.isSuccess(byId)) {
            UserVO userVO = byId.getData();
            strategyVO.setNickname(userVO.getNickname());
            strategyVO.setImage(userVO.getImage());
        }
        return strategyVO;
    }


    @Override
    public StrategyVO add(StrategyDTO strategyDTO) throws BaseException {
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyDTO, strategy);
        int insert = strategyMapper.insert(strategy);
        if (insert < 1) {
            log.error("添加攻略失败：{}", strategyDTO);
            throw new BaseException(ResultCode.ERROR);
        }
        StrategyVO strategyVO = strategytoStrategyVO(strategy);
        return strategyVO;
    }
}
