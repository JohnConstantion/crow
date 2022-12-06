/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.pojo.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @author johnconstantine
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserBo {
    @NotBlank(message = "name must be have value")
    @Length(min = 1, max = 24, message = "username length must be between 1 and 24")
    private String username;
    @NotNull(message = "password must be have value")
    @Size(min = 1, max = 24, message = "password must be between 1 and 24")
    private String password;
    @NotNull(message = "confirm password must be have value")
    @Size(min = 1, max = 24, message = "confirm password must be between 1 and 24")
    private String confirmPassword;
}
