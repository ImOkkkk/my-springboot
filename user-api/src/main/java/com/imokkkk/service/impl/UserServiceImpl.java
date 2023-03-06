package com.imokkkk.service.impl;

import com.imokkkk.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author liuwy
 * @date 2023/3/6 9:22
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String test() {
        return "SUCCESS!";
    }
}
