package com.smart.travel.service.travel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 景点表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "scenic_spot")
public class ScenicSpot {
    /**
     * ID
     */
    @TableId(value = "scenic_spot_id", type = IdType.AUTO)
    private Long scenicSpotId;

    /**
     * 景点名字
     */
    @TableField(value = "scenic_spot_name")
    private String scenicSpotName;

    /**
     * 图片
     */
    @TableField(value = "images")
    private String images;

    /**
     * 评分
     */
    @TableField(value = "grade")
    private Long grade;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

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

    /**
     * 景点介绍
     */
    @TableField(exist = false)
    private ScenicSpotIntroduction scenicSpotIntroduction;

    /**
     * 游记
     */
    @TableField(exist = false)
    private List<TravelNote> travelNoteList;

    /**
     * 攻略
     */
    @TableField(exist = false)
    private List<Strategy> strategyList;

    public static final String COL_SCENIC_SPOT_ID = "scenic_spot_id";

    public static final String COL_SCENIC_SPOT_NAME = "scenic_spot_name";

    public static final String COL_IMAGES = "images";

    public static final String COL_GRADE = "grade";

    public static final String COL_TITLE = "title";

    public static final String COL_CREATOR_ID = "creator_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIER_ID = "modifier_id";

    public static final String COL_MODIFIER_TIME = "modifier_time";

    public static final String COL_IS_DELETE = "is_delete";
}