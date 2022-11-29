/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.api;

import io.micrometer.common.util.StringUtils;
import org.john.crow.common.util.JsonResult;
import org.john.crow.pojo.bo.UserBo;
import org.john.crow.pojo.entity.Users;
import org.john.crow.pojo.records.User;
import org.john.crow.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author johnconstantine
 */
@RestController
@RequestMapping("/passport")
public class UserController {
    private final UserService userService;
    private final Integer SIX = 6;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/username_is_exist")
    public JsonResult queryUserByUserName(String username) {
        if (StringUtils.isEmpty(username)) {
            return JsonResult.errorMsg("name must be have value");
        }
        Users users = userService.queryByUserName(username).orElse(null);
        if (null != users) {
            return JsonResult.errorMsg("User is found, Please try other name");
        }
        return JsonResult.ok();
    }

    @PostMapping("/regist")
    public JsonResult createUser(@RequestBody UserBo userBo) {
        if (StringUtils.isEmpty(userBo.getUsername()) || StringUtils.isEmpty(userBo.getPassword()) || StringUtils.isEmpty(userBo.getConfirmPassword())) {
            return JsonResult.errorMsg("username or password must be have value");
        }

        Users users = userService.queryByUserName(userBo.getUsername()).orElse(null);
        if (null != users) {
            return JsonResult.errorMsg("User is found, Please try other name");
        }

        if (userBo.getPassword().length() < SIX) {
            return JsonResult.errorMsg("password length must be greater then " + SIX);
        }

        if (!userBo.getPassword().equals(userBo.getConfirmPassword())) {
            return JsonResult.errorMsg("password and confirmPassword do not match");
        }

        User user = userService.createUser(userBo);
        if (null == user) {
            return JsonResult.errorMsg("create user failed");
        }
        return JsonResult.ok(user);
    }

}
