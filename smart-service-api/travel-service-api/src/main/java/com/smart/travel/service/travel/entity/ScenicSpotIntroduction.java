package com.smart.travel.service.travel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 景点介绍表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "scenic_spot_introduction")
public class ScenicSpotIntroduction {
    /**
     * ID
     */
    @TableId(value = "scenic_spot_introduction_id", type = IdType.AUTO)
    private Long scenicSpotIntroductionId;

    /**
     * 景点ID
     */
    @TableField(value = "scenic_spot_id")
    private Long scenicSpotId;

    /**
     * 介绍
     */
    @TableField(value = "introduction")
    private String introduction;

    /**
     * 最佳游览时间
     */
    @TableField(value = "optimum_visit_time")
    private String optimumVisitTime;

    /**
     * 最佳游览时间说明
     */
    @TableField(value = "optimum_visit_time_explain")
    private String optimumVisitTimeExplain;

    /**
     * 建议游玩天数
     */
    @TableField(value = "recommend_play_days")
    private String recommendPlayDays;

    /**
     * 建议游玩天数说明
     */
    @TableField(value = "recommend_play_days_explain")
    private String recommendPlayDaysExplain;

    /**
     * 消费水平
     */
    @TableField(value = "consumption_level")
    private String consumptionLevel;

    /**
     * 消费水平说明
     */
    @TableField(value = "consumption_level_explain")
    private String consumptionLevelExplain;

    /**
     * 创建者id
     */
    @TableField(value = "creator_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新者id
     */
    @TableField(value = "modifier_id")
    private Long modifierId;

    /**
     * 更新时间
     */
    @TableField(value = "modifier_time")
    private LocalDateTime modifierTime;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    public static final String COL_SCENIC_SPOT_INTRODUCTION_ID = "scenic_spot_introduction_id";

    public static final String COL_SCENIC_SPOT_ID = "scenic_spot_id";

    public static final String COL_INTRODUCTION = "introduction";

    public static final String COL_OPTIMUM_VISIT_TIME = "optimum_visit_time";

    public static final String COL_OPTIMUM_VISIT_TIME_EXPLAIN = "optimum_visit_time_explain";

    public static final String COL_RECOMMEND_PLAY_DAYS = "recommend_play_days";

    public static final String COL_RECOMMEND_PLAY_DAYS_EXPLAIN = "recommend_play_days_explain";

    public static final String COL_CONSUMPTION_LEVEL = "consumption_level";

    public static final String COL_CONSUMPTION_LEVEL_EXPLAIN = "consumption_level_explain";

    public static final String COL_CREATOR_ID = "creator_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIER_ID = "modifier_id";

    public static final String COL_MODIFIER_TIME = "modifier_time";

    public static final String COL_IS_DELETE = "is_delete";
}