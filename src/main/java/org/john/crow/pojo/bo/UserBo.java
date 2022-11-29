/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author johnconstantine
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserBo {
    private String username;
    private String password;
    private String confirmPassword;
}
