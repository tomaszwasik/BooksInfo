package com.tomaszwasik.service.impl;

import com.tomaszwasik.data.User;
import com.tomaszwasik.entity.UserEntity;
import com.tomaszwasik.repository.UserRepository;
import com.tomaszwasik.service.UserService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private Random r;
    private Long count = null;

    @Override
    public User findUserByRandomId() {

        if(count == null){
            count = userRepository.count();
        }

        long randomId = (long)getRandomNumberInRange(count.intValue());
        UserEntity userEntity = userRepository.findOne(randomId);

        if(userEntity == null){
            findUserByRandomId();
        }

        mapperFactory.classMap(UserEntity.class, User.class).byDefault();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(userEntity, User.class);
    }

    private int getRandomNumberInRange(int max) {
        if (1 >= max) {
            throw new IllegalArgumentException("max must be greater than min = 1");
        }
        if(r == null){
            r = new Random();
        }
        return r.nextInt((max - 1) + 1) + 1;
    }
}
