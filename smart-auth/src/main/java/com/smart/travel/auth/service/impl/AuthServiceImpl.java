package com.smart.travel.auth.service.impl;


import cn.hutool.core.util.RandomUtil;
import com.smart.travel.auth.service.AuthService;
import com.smart.travel.auth.vo.AuthVO;
import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.result.ResultCode;
import com.smart.travel.common.core.utils.JwtUtils;
import com.smart.travel.common.redis.service.RedisService;
import com.smart.travel.service.user.dto.UserDTO;
import com.smart.travel.service.user.entity.User;
import com.smart.travel.service.user.feign.service.UserService;
import com.smart.travel.service.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Resource
    UserService userService;

    @Resource
    RedisService redisService;

    /**
     * 注册
     *
     * @param userDTO 用户对象  根据username password
     * @return 返回认证对象 包括token 等其他信息
     * @throws BaseException
     */
    @Override
    public AuthVO register(UserDTO userDTO) throws BaseException {
        BaseResult<UserVO> baseResult = userService.getByUsername(userDTO.getUsername());
        if (BaseResult.isSuccess(baseResult)) {
            log.error("注册失败，用户已存在，用户:{}", userDTO);
            throw new BaseException(ResultCode.ERROR.getStatus(), "用户已存在");
        }
        UserVO userVO = baseResult.getData();
        if (userVO != null) {
            log.error("注册失败，用户已存在，用户：{}", userDTO);
            throw new BaseException(ResultCode.ERROR.getStatus(), "用户已存在");
        }
        BaseResult<UserVO> save = userService.save(userDTO);

        if (!BaseResult.isSuccess(save)) {
            log.error("注册失败:{}", userDTO);
            throw new BaseException(ResultCode.ERROR.getStatus(), "注册失败");
        }
        userVO = save.getData();
        //生产token
        AuthVO authVO = new AuthVO();
        BeanUtils.copyProperties(userVO, authVO);
        authVO.setToken(JwtUtils.createJWT(authVO.getUserId(), authVO.getUsername()));
        return authVO;
    }

    /**
     * 登录
     *
     * @param userDTO 用户对象  根据username password
     * @return 返回认证对象 包括token 等其他信息
     * @throws BaseException
     */
    @Override
    public AuthVO login(UserDTO userDTO) throws BaseException {
        BaseResult<UserVO> byUsername = userService.getByUsername(userDTO.getUsername());
        if (!BaseResult.isSuccess(byUsername)) {
            log.error("登录失败", userDTO);
            throw new BaseException(ResultCode.ACCOUNT_LOGIN_ERROR);
        }
        UserVO userVO = byUsername.getData();
        if (userVO == null) {
            log.error("登录失败，用户不存在，用户：{}", userDTO);
            throw new BaseException(ResultCode.ACCOUNT_LOGIN_ERROR);
        }
        if (!userDTO.getPassword().equals(userVO.getPassword())) {
            log.error("登录失败，用户密码错误，用户：{}", userDTO);
            throw new BaseException(ResultCode.ACCOUNT_LOGIN_ERROR);
        }
        //生产token
        AuthVO authVO = new AuthVO();
        BeanUtils.copyProperties(userVO, authVO);
        authVO.setToken(JwtUtils.createJWT(userVO.getUserId(), userVO.getUsername()));
        return authVO;
    }

    @Override
    public AuthVO loginPhone(String phone, String code) throws BaseException {
        Boolean hasKey = redisService.hasKey(phone);
        if (!hasKey) {
            log.error("验证吗过期：{}->{}", phone, code);
            throw new BaseException(ResultCode.CODE_LOGIN_ERROR);
        }
        Object o = redisService.get(phone);
        if (!code.equals(o.toString())) {
            log.error("手机验证码不正确：{}->{}", phone, code);
            throw new BaseException(ResultCode.CODE_LOGIN_ERROR);
        }
        BaseResult<UserVO> byPhone = userService.getByPhone(phone);
        UserVO userVO = null;
        AuthVO authVO = new AuthVO();
        if (BaseResult.isSuccess(byPhone)) {
            userVO = byPhone.getData();
        } else {
            UserDTO user = new UserDTO();
            user.setPhone(phone);
            user.setNickname("travel" + RandomUtil.randomNumbers(4));
//            user.setImage();
            user.setIntroduction("世界那么大，我想出去走走～");
            BaseResult<UserVO> save = userService.save(user);
            if (!BaseResult.isSuccess(save)) {
                log.error("验证吗正确，添加用户失败：{}->{}", phone, code);
                throw new BaseException(ResultCode.CODE_LOGIN_ERROR);
            }
            userVO = save.getData();
        }
        BeanUtils.copyProperties(userVO, authVO);
        authVO.setToken(JwtUtils.createJWT(userVO.getUserId(), userVO.getUsername()));
        return authVO;
    }
}
