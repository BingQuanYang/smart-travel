package com.smart.travel.service.travel.controller;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.result.PageResult;
import com.smart.travel.service.travel.service.ScenicSpotService;
import com.smart.travel.service.travel.vo.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 景区
 *
 * @author ybq
 */
@RestController
@RequestMapping("/travel")
public class TravelController {
    @Resource
    ScenicSpotService scenicSpotService;

    @GetMapping("/detail/{id}")
    public BaseResult<TravelDetailVO> detail(@PathVariable("id") long id) throws BaseException {
        return BaseResult.success(scenicSpotService.getThreeById(id));
    }

    @GetMapping("/list/{page}")
    public BaseResult<PageResult<ScenicSpotVO>> list(@PathVariable("page") Long page) throws BaseException {
        return BaseResult.success(scenicSpotService.list(page, 9L));
    }


    @GetMapping("/mine/{userId}")
    public BaseResult<MineVO> mine(@PathVariable("userId") Long userId) throws BaseException {
        return BaseResult.success(scenicSpotService.mine(userId));
    }

    @GetMapping("/strategy")
    public BaseResult<NavStrategyVO> strategy() throws BaseException {
        return BaseResult.success(scenicSpotService.strategy());
    }

    @GetMapping("/index")
    public BaseResult<HomeVO> index() throws BaseException {
        return BaseResult.success(scenicSpotService.index());
    }
}
