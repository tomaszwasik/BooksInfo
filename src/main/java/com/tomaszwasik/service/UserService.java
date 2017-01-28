package com.tomaszwasik.service;

import com.tomaszwasik.data.User;
import com.tomaszwasik.entity.UserEntity;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
public interface UserService {

    User findUserByRandomId();


    UserEntity findUserByUsername(String username);
}
