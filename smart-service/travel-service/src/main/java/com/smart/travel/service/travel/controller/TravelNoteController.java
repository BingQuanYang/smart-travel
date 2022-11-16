package com.smart.travel.service.travel.controller;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.service.travel.dto.TravelNoteDTO;
import com.smart.travel.service.travel.entity.TravelNote;
import com.smart.travel.service.travel.service.TravelNoteService;
import com.smart.travel.service.travel.vo.StrategyVO;
import com.smart.travel.service.travel.vo.TravelNoteVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ybq
 */
@RestController
@RequestMapping("/travel/travelNote")
public class TravelNoteController {

    @Resource
    TravelNoteService travelNoteService;

    @GetMapping("/getById/{id}")
    public BaseResult<TravelNoteVO> getById(@PathVariable("id") Long id) throws BaseException {
        return BaseResult.success(travelNoteService.getById(id));
    }

    @GetMapping("/list/{page}")
    public BaseResult<PageResult<TravelNoteVO>> list(@PathVariable("page") Long page) throws BaseException {
        return BaseResult.success(travelNoteService.list(page, 8L));
    }

    @GetMapping("/listByUserId/{userId}/{page}")
    public BaseResult<PageResult<TravelNoteVO>> listByUserId(@PathVariable("userId") Long userId, @PathVariable("page") Long page) throws BaseException {
        return BaseResult.success(travelNoteService.listByUserId(userId, page, 8L));
    }

    @PostMapping("/add")
    public BaseResult<TravelNoteVO> add(@RequestBody TravelNoteDTO travelNoteDTO) throws BaseException {
        return BaseResult.success(travelNoteService.add(travelNoteDTO));
    }

}
