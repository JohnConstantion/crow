/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.john.crow.common.utils.CookieUtils;
import org.john.crow.common.utils.JsonResult;
import org.john.crow.common.utils.JsonUtils;
import org.john.crow.pojo.bo.LoginBo;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/username_is_exist")
    public JsonResult queryUserByUserName(@RequestParam String username) {
        Users users = userService.queryByUserName(username).orElse(null);
        if (null != users) {
            return JsonResult.errorMsg("User is found, Please try other name");
        }
        return JsonResult.ok();
    }

    @PostMapping("/register")
    public JsonResult createUser(@Valid @RequestBody UserBo userBo, HttpServletRequest request, HttpServletResponse response) {
        Users users = userService.queryByUserName(userBo.getUsername()).orElse(null);
        if (null != users) {
            return JsonResult.errorMsg("User is found, Please try other name");
        }

        if (!userBo.getPassword().equals(userBo.getConfirmPassword())) {
            return JsonResult.errorMsg("password and confirmPassword do not match");
        }

        User user = userService.createUser(userBo);
        if (null == user) {
            return JsonResult.errorMsg("create user failed");
        }
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);
        return JsonResult.ok(user);
    }

    @PostMapping("/login")
    public JsonResult login(@Valid @RequestBody LoginBo loginBo, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.queryUserForLogin(loginBo.getUsername(), loginBo.getPassword());
        if (null == user) {
            return JsonResult.errorMsg("User is not found,please check username or password");
        }
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);
        return JsonResult.ok(user);
    }

}
