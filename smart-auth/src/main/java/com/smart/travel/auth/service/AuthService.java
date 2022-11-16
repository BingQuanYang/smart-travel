package com.smart.travel.auth.service;


import com.smart.travel.auth.vo.AuthVO;
import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.service.user.dto.UserDTO;

public interface AuthService {
    /**
     * 注册
     *
     * @param userDTO 用户对象  根据username password
     * @return 返回认证对象 包括token 等其他信息
     * @throws BaseException
     */
    AuthVO register(UserDTO userDTO) throws BaseException;

    /**
     * 登录
     *
     * @param userDTO 用户对象  根据username password
     * @return 返回认证对象 包括token 等其他信息
     * @throws BaseException
     */
    AuthVO login(UserDTO userDTO) throws BaseException;

    AuthVO loginPhone(String phone, String code) throws BaseException;
}
