package com.smart.travel.service.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User extends Role {
    /**
     * 主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 个人简介
     */
    @TableField(value = "introduction")
    private String introduction;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private LocalDate birthday;

    /**
     * 手机
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 头像
     */
    @TableField(value = "image")
    private String image;

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

    @TableField(exist = false)
    private List<Role> roleList;

    @TableField(value = "is_delete")
    private Integer isDelete;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_EMAIL = "email";

    public static final String COL_SEX = "sex";

    public static final String COL_INTRODUCTION = "introduction";

    public static final String COL_BIRTHDAY = "birthday";

    public static final String COL_PHONE = "phone";

    public static final String COL_IMAGE = "image";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATOR_ID = "creator_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIER_ID = "modifier_id";

    public static final String COL_MODIFIER_TIME = "modifier_time";

    public static final String COL_IS_DELETE = "is_delete";

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        //随机赋值
        int num_flag = 0;
        for (int i = 0; i < arr.length; i++) {
            //[10000,99999]
            arr[i] = random.nextInt(99999 - 10000 + 1) + 10000;
            if (i == 0) {
                num_flag = arr[i];
            }
        }
        //升序排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        int sum = num_flag * 2;
        int bit =String.valueOf(sum).length();
        System.out.println(num_flag + "*2等于" + sum + ",几位数:" + bit);
        char[] sumChars = String.valueOf(num_flag).toCharArray();

        for (int i = sumChars.length-1; i >= 0; i--) {
            System.out.println(sumChars[i]);
        }
    }

}