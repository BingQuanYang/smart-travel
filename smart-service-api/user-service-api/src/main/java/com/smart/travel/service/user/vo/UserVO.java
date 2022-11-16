package com.smart.travel.service.user.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.smart.travel.service.user.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ybq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
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

    private List<RoleVO> roleVOList;
}
