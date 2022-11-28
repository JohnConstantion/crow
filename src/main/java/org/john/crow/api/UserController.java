/*
 * Copyright (c) 2022, Constantine John. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package org.john.crow.api;

import io.micrometer.common.util.StringUtils;
import org.john.crow.common.util.JsonResult;
import org.john.crow.pojo.entity.Users;
import org.john.crow.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
