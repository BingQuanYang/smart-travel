package com.smart.travel.service.user.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleVO {
    /**
     * 主键
     */
    private Long roleId;

    /**
     * 用户名
     */
    private String roleName;
}