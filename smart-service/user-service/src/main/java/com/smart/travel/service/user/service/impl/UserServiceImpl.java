package com.smart.travel.service.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.common.core.result.ResultCode;
import com.smart.travel.common.core.utils.BeanCopyUtils;
import com.smart.travel.service.user.dto.UserDTO;
import com.smart.travel.service.user.entity.User;
import com.smart.travel.service.user.mapper.UserMapper;
import com.smart.travel.service.user.service.UserService;
import com.smart.travel.service.user.vo.RoleVO;
import com.smart.travel.service.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ybq
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public UserVO getByUsername(String username) throws BaseException {
        UserVO userVO = null;
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUsername, username));
            if (user != null) {
                userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
            } else {
                throw new BaseException(ResultCode.ERROR);
            }
        } catch (Exception e) {
            log.error("根据用户名获取用户信息失败:{}", e.getMessage());
            throw new BaseException(ResultCode.ERROR.getStatus(), String.format("根据用户名获取用户信息失败（T）:{}", e.getMessage()));
        }
        return userVO;
    }

    @Override
    public UserVO getThreeByUsername(String username) throws BaseException {
        UserVO userVO = null;
        try {
            User user = userMapper.getThreeByUsername(username);
            if (user != null) {
                userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
                List<RoleVO> roleVOList = BeanCopyUtils.copyListProperties(user.getRoleList(), RoleVO::new);
                userVO.setRoleVOList(roleVOList);
            } else {
                throw new BaseException(ResultCode.ERROR);
            }
        } catch (Exception e) {
            log.error("根据用户名获取用户信息失败（T）:{}", e.getMessage());
            throw new BaseException(ResultCode.ERROR.getStatus(), String.format("根据用户名获取用户信息失败（T）:{}", e.getMessage()));
        }
        return userVO;
    }

    @Override
    public UserVO save(UserDTO userDTO) {
        UserVO userVO = null;
        try {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            int insert = userMapper.insert(user);
            if (insert < 1) {
                throw new BaseException(ResultCode.ERROR);
            }
            userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
        } catch (Exception e) {
            log.error("添加用户失败：{}", e.getMessage());
        }
        return userVO;
    }

    @Override
    public UserVO getByPhone(String phone) throws BaseException {
        UserVO userVO = null;
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getPhone, phone));
            if (user != null) {
                userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
            } else {
                throw new BaseException(ResultCode.ERROR);
            }
        } catch (Exception e) {
            log.error("根据手机号码获取用户信息失败:{}", e.getMessage());
            throw new BaseException(ResultCode.ERROR.getStatus(), String.format("根据手机号码获取用户信息失败:{}", e.getMessage()));
        }
        return userVO;
    }

    @Override
    public UserVO getById(Long id) throws BaseException {
        UserVO userVO = null;
        try {
            User user = userMapper.selectById(id);
            if (user != null) {
                userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
            } else {
                throw new BaseException(ResultCode.ERROR);
            }
        } catch (Exception e) {
            log.error("根据id获取用户信息失败:{}", e.getMessage());
            throw new BaseException(ResultCode.ERROR.getStatus(), String.format("根据id获取用户信息失败:{}", e.getMessage()));
        }
        return userVO;
    }
}
