/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.service;

import org.john.crow.pojo.bo.UserBo;
import org.john.crow.pojo.entity.Users;
import org.john.crow.pojo.records.User;

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


    /**
     * create user
     *
     * @param userBo user.username and password
     * @return if create user error, return null otherwise return user
     */
    User createUser(UserBo userBo);

    /**
     * select user by username and password
     *
     * @param username username
     * @param password password
     * @return {@code User}if user not found,return null otherwise return user
     */
    User queryUserForLogin(String username, String password);
}
