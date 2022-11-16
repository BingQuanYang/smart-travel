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
    * 攻略表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "strategy")
public class Strategy {
    /**
     * 主键
     */
    @TableId(value = "strategy_id", type = IdType.AUTO)
    private Long strategyId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 景点ID
     */
    @TableField(value = "scenic_spot_id")
    private Long scenicSpotId;

    /**
     * 主标题
     */
    @TableField(value = "main_title")
    private String mainTitle;

    /**
     * 主内容
     */
    @TableField(value = "main_content")
    private String mainContent;

    /**
     * 封面
     */
    @TableField(value = "cover")
    private String cover;

    /**
     * 副标题1
     */
    @TableField(value = "subhead_first")
    private String subheadFirst;

    /**
     * 内容1
     */
    @TableField(value = "content_first")
    private String contentFirst;

    /**
     * 图片1
     */
    @TableField(value = "images_first")
    private String imagesFirst;

    /**
     * 副标题1
     */
    @TableField(value = "subhead_second")
    private String subheadSecond;

    /**
     * 内容1
     */
    @TableField(value = "content_second")
    private String contentSecond;

    /**
     * 图片1
     */
    @TableField(value = "images_second")
    private String imagesSecond;

    /**
     * 状态:1->正常，0->禁用
     */
    @TableField(value = "status")
    private Integer status;

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

    @TableField(value = "is_delete")
    private Integer isDelete;

    public static final String COL_STRATEGY_ID = "strategy_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_SCENIC_SPOT_ID = "scenic_spot_id";

    public static final String COL_MAIN_TITLE = "main_title";

    public static final String COL_MAIN_CONTENT = "main_content";

    public static final String COL_COVER = "cover";

    public static final String COL_SUBHEAD_FIRST = "subhead_first";

    public static final String COL_CONTENT_FIRST = "content_first";

    public static final String COL_IMAGES_FIRST = "images_first";

    public static final String COL_SUBHEAD_SECOND = "subhead_second";

    public static final String COL_CONTENT_SECOND = "content_second";

    public static final String COL_IMAGES_SECOND = "images_second";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATOR_ID = "creator_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIER_ID = "modifier_id";

    public static final String COL_MODIFIER_TIME = "modifier_time";

    public static final String COL_IS_DELETE = "is_delete";
}