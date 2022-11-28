/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.service.impl;

import org.john.crow.mapper.UserJpaRepository;
import org.john.crow.pojo.entity.Users;
import org.john.crow.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author johnconstantine
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

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
}
