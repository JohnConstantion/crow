/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.mapper;

import org.john.crow.pojo.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author johnconstantine
 */
public interface UserJpaRepository extends CrudRepository<Users, Long> {

    /**
     * select user by username
     *
     * @param username {@code User.username}
     * @return if user is not found,return null otherwise return user
     */
    Optional<Users> findByUsername(String username);

    /**
     * select user by username and password
     *
     * @param username username
     * @param password password
     * @return {@code user}
     */
    Optional<Users> findUsersByUsernameAndPassword(String username, String password);
}
