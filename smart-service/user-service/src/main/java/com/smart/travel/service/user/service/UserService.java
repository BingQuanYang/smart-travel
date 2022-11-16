package com.smart.travel.service.user.service;

import com.smart.travel.common.core.base.BaseException;
import com.smart.travel.service.user.dto.UserDTO;
import com.smart.travel.service.user.entity.User;
import com.smart.travel.service.user.vo.UserVO;

/**
 * @author ybq
 */
public interface UserService {
    UserVO getByUsername(String username) throws BaseException;

    UserVO save(UserDTO userDTO);

    UserVO getThreeByUsername(String username) throws BaseException;

    UserVO getByPhone(String phone) throws BaseException;

    UserVO getById(Long id) throws BaseException;
}
