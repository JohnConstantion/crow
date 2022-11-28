/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.service;

import org.john.crow.pojo.entity.Users;

import java.util.Optional;

/**
 * @author johnconstantine
 */
public interface UserService {

    /**
     * select user by id
     *
     * @param id {@code User.id}
     * @return if user is not found,return null otherwise return user
     */
    Optional<Users> queryUserById(Long id);

    /**
     * select user by username
     *
     * @param username {@code User.username}
     * @return if user is not found,return null otherwise return user
     */
    Optional<Users> queryByUserName(String username);
}
