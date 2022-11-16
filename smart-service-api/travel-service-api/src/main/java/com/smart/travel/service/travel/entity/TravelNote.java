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
    * 游记表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "travel_note")
public class TravelNote {
    /**
     * ID
     */
    @TableId(value = "travel_note_id", type = IdType.AUTO)
    private Long travelNoteId;

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
     * 图片
     */
    @TableField(value = "images")
    private String images;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

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

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    public static final String COL_TRAVEL_NOTE_ID = "travel_note_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_SCENIC_SPOT_ID = "scenic_spot_id";

    public static final String COL_IMAGES = "images";

    public static final String COL_CONTENT = "content";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATOR_ID = "creator_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIER_ID = "modifier_id";

    public static final String COL_MODIFIER_TIME = "modifier_time";

    public static final String COL_IS_DELETE = "is_delete";
}