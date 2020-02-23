package com.heshi.security.controller;

import com.heshi.security.entity.User;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户信息Controller")
@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "获取用户名")
    @GetMapping("/getUserName")
    @ResponseBody
    public String getUserName() {
        return "heshi";
    }

    @ApiOperation(value = "查询用户信息")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "请求路径不对或页面路径跳转不对")
    })
    @ApiImplicitParam(paramType = "path", name = "userId", dataType = "Long", required = true, value = "用户id", defaultValue = "")
    @GetMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser(@ApiParam(name = "userId", value = "用户id", required = true) @PathVariable Long userId) {
        logger.info("userId:{}", userId);
        User user = new User();
        user.setUserName("heshi");
        user.setPassword("k");
        user.setAge(28);
        user.setId(userId);
        return user;
    }

    @ApiOperation(value = "保存用户", httpMethod = "POST", notes = "保存用户信息，备注")
    @PostMapping(value = "/aa/bb", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String save() {
        logger.info("save user");
        return "save user";
    }
}
