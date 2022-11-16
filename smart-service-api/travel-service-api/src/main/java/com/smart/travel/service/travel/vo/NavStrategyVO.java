package com.smart.travel.service.travel.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ybq
 */
@Data
public class NavStrategyVO {
    /**
     * 攻略
     */
    private List<StrategyVO> strategyVOList;

    /**
     * 游记
     */
    private List<TravelNoteVO> travelNoteVOList;

}
