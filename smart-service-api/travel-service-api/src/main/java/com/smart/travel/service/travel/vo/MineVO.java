package com.smart.travel.service.travel.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ybq
 */
@Data
public class MineVO {
    /**
     * 攻略
     */
    private StrategyVO strategyVO;

    /**
     * 游记
     */
    private List<TravelNoteVO> travelNoteVOList;
}
