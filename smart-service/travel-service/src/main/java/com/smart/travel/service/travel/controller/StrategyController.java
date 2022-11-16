package com.smart.travel.service.travel.controller;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.service.travel.dto.StrategyDTO;
import com.smart.travel.service.travel.service.StrategyService;
import com.smart.travel.service.travel.vo.NavStrategyVO;
import com.smart.travel.service.travel.vo.ScenicSpotVO;
import com.smart.travel.service.travel.vo.StrategyVO;
import com.smart.travel.service.travel.vo.TravelNoteVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ybq
 */
@RestController
@RequestMapping("/travel/strategy")
public class StrategyController {

    @Resource
    StrategyService strategyService;

    @GetMapping("/getById/{id}")
    public BaseResult<StrategyVO> getById(@PathVariable("id") Long id) throws BaseException {
        return BaseResult.success(strategyService.getById(id));
    }

    @GetMapping("/list/{page}")
    public BaseResult<PageResult<StrategyVO>> list(@PathVariable("page") Long page) throws BaseException {
        return BaseResult.success(strategyService.list(page, 5L));
    }

    @GetMapping("/listByUserId/{userId}/{page}")
    public BaseResult<PageResult<StrategyVO>> listByUserId(@PathVariable("userId") Long userId, @PathVariable("page") Long page) throws BaseException {
        return BaseResult.success(strategyService.listByUserId(userId, page, 5L));
    }

    @PostMapping("/add")
    public BaseResult<StrategyVO> add(@RequestBody StrategyDTO strategyDTO) throws BaseException {
        return BaseResult.success(strategyService.add(strategyDTO));
    }
}
