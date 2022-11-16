package com.smart.travel.service.travel.service;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.service.travel.dto.StrategyDTO;
import com.smart.travel.service.travel.vo.NavStrategyVO;
import com.smart.travel.service.travel.vo.StrategyVO;

/**
 * @author ybq
 */
public interface StrategyService {
    StrategyVO getById(Long id) throws BaseException;

    PageResult<StrategyVO> list(Long page, Long size) throws BaseException;

    PageResult<StrategyVO> listByUserId(Long userId, Long page, Long size) throws BaseException;

    StrategyVO getByUserId(Long userId);

    StrategyVO add(StrategyDTO strategyDTO) throws BaseException;
}
