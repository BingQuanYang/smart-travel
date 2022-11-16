package com.smart.travel.service.user.dto;

import com.smart.travel.service.user.vo.RoleVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ybq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    /**
     * 主键
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 个人简介
     */
    private String introduction;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 手机
     */
    private String phone;

    /**
     * 头像
     */
    private String image;

}
