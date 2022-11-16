package com.smart.travel.auth.controller;


import com.smart.travel.auth.service.AuthService;
import com.smart.travel.auth.vo.AuthVO;
import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.BaseResult;
import com.smart.travel.common.core.utils.JwtUtils;
import com.smart.travel.common.redis.service.RedisService;
import com.smart.travel.common.web.utils.RequestUtils;
import com.smart.travel.service.user.dto.UserDTO;
import com.smart.travel.service.user.entity.User;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * 认证
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    AuthService authService;

    @Resource
    RedisService redisService;

    /**
     * 注册
     *
     * @param userDTO 用户对象
     * @return 认证对象
     * @throws BaseException
     */
    @PostMapping("/register")
    public BaseResult<AuthVO> register(@RequestBody UserDTO userDTO) throws BaseException {
        return BaseResult.success(authService.register(userDTO));
    }

    /**
     * 登录
     *
     * @param userDTO
     * @return 认证对象
     * @throws BaseException
     */
    @PostMapping("login")
    public BaseResult<AuthVO> login(@RequestBody UserDTO userDTO) throws BaseException {
        return BaseResult.success(authService.login(userDTO));
    }

    /**
     * 手机验证码登录
     *
     * @return 认证对象
     * @throws BaseException
     */
    @PostMapping("/loginPhone/{phone}/{code}")
    public BaseResult<AuthVO> loginPhone(@PathVariable("phone") String phone, @PathVariable("code") String code) throws BaseException {
        return BaseResult.success(authService.loginPhone(phone, code));
    }


    /**
     * 登出
     *
     * @return
     */
    @DeleteMapping("/logout")
    public BaseResult logout() {
        String token = RequestUtils.getToken();
        // JWT唯一标识
        Claims claims = JwtUtils.verifyJwt(token);
        if (claims == null) {
            // token已过期，无需加入黑名单
            return BaseResult.success();
        }
        String jti = claims.get("jti", String.class);
        // JWT过期时间戳
        long exp = claims.getExpiration().getTime() / 1000;
        long currentTimeSeconds = System.currentTimeMillis() / 1000;
        if (exp < currentTimeSeconds) {
            // token已过期，无需加入黑名单
            return BaseResult.success();
        }
        redisService.setEx("auth:token:blacklist:" + jti, null, (exp - currentTimeSeconds), TimeUnit.SECONDS);
        return BaseResult.success();
    }
}

