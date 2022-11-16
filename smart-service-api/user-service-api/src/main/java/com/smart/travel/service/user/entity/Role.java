package com.smart.travel.service.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    * 角色表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`role`")
public class Role {
    /**
     * 主键
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 用户名
     */
    @TableField(value = "role_name")
    private String roleName;

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

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_ROLE_NAME = "role_name";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATOR_ID = "creator_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIER_ID = "modifier_id";

    public static final String COL_MODIFIER_TIME = "modifier_time";

    public static final String COL_IS_DELETE = "is_delete";

    public void ss(){}
}