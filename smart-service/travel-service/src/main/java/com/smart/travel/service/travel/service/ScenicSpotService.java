package com.smart.travel.service.travel.service;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.service.travel.vo.*;

/**
 * @author ybq
 */
public interface ScenicSpotService {
    /**
     * 根据景点id获取景点详细信息
     * 树形结构
     *
     * @param id
     * @return
     */
    TravelDetailVO getThreeById(long id) throws BaseException;

    MineVO mine(Long userId) throws BaseException;

    NavStrategyVO strategy() throws BaseException;

    PageResult<ScenicSpotVO> list(Long page, Long size);

    HomeVO index() throws BaseException;
}
