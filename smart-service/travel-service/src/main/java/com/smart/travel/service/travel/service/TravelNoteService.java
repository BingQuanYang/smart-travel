package com.smart.travel.service.travel.service;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.service.travel.dto.TravelNoteDTO;
import com.smart.travel.service.travel.vo.TravelNoteVO;

/**
 * @author ybq
 */
public interface TravelNoteService {
    TravelNoteVO getById(Long id) throws BaseException;

    PageResult<TravelNoteVO> list(Long page,Long size) throws BaseException;

    PageResult<TravelNoteVO> listByUserId(Long userId, Long page,Long size) throws BaseException;

    TravelNoteVO add(TravelNoteDTO travelNoteDTO) throws BaseException;
}
