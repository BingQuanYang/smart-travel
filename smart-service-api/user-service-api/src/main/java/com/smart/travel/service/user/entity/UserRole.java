package com.smart.travel.service.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    *  用户角色表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_role")
public class UserRole {
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 状态:1->正常，0->禁用
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(value = "is_delete")
    private Integer isDelete;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_STATUS = "status";

    public static final String COL_IS_DELETE = "is_delete";
}