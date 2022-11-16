package com.smart.travel.service.travel.vo;

import lombok.Data;

/**
 * @author ybq
 */
@Data
public class ScenicSpotIntroductionVO {
    /**
     * ID
     */
    private Long scenicSpotIntroductionId;

    /**
     * 景点ID
     */
    private Long scenicSpotId;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 最佳游览时间
     */
    private String optimumVisitTime;

    /**
     * 最佳游览时间说明
     */
    private String optimumVisitTimeExplain;

    /**
     * 建议游玩天数
     */
    private String recommendPlayDays;

    /**
     * 建议游玩天数说明
     */
    private String recommendPlayDaysExplain;

    /**
     * 消费水平
     */
    private String consumptionLevel;

    /**
     * 消费水平说明
     */
    private String consumptionLevelExplain;

}
