/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.service.impl;

import org.john.crow.common.enums.Sex;
import org.john.crow.common.utils.DateUtil;
import org.john.crow.common.utils.BaseUtils;
import org.john.crow.mapper.UserJpaRepository;
import org.john.crow.pojo.bo.UserBo;
import org.john.crow.pojo.entity.Users;
import org.john.crow.pojo.records.User;
import org.john.crow.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * @author johnconstantine
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;
    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    public UserServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<Users> queryUserById(Long id) {
        return userJpaRepository.findById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public Optional<Users> queryByUserName(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public User createUser(UserBo userBo) {
        Users users = new Users();
        users.setId(Sid.next());
        users.setUsername(userBo.getUsername());
        users.setPassword(BaseUtils.getBase64(userBo.getPassword()));
        // default nickname is username
        users.setNickname(userBo.getUsername());
        // default face
        users.setFace(USER_FACE);
        // default birthday
        users.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // default sex
        users.setSex(Sex.SECRET.type);

        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());

        userJpaRepository.save(users);
        return new User(users.getId(), users.getNickname(), users.getFace(), users.getSex());
    }

    @Override
    public User queryUserForLogin(String username, String password) {
        Optional<Users> user = userJpaRepository.findUsersByUsernameAndPassword(username, BaseUtils.getBase64(password));
        if (user.isPresent()) {
            Users users = user.get();
            return new User(users.getId(), users.getNickname(), users.getFace(), users.getSex());
        }
        return null;
    }
}
