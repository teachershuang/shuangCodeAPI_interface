package com.shuang.shuangcodeinterface.controller;


import com.shuang.shuangcodeclientsdk.model.User;
import com.shuang.shuangcodeclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 查询名称
 * @author shuang
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameUsingGet(String name) {
        return "你的名字是Get" + name;
    }


    @PostMapping("/")
    public String getNameUsingPost(String name) {
        return "你的名字是Post"+ name;
    }

    @PostMapping("/user")
    public String getUserNameUsingPost(@RequestBody User user, HttpServletRequest httpServerRequest) {
        String accessKey = httpServerRequest.getHeader("accessKey");
        String nonce = httpServerRequest.getHeader("nonce");
        String body = httpServerRequest.getHeader("body");
        String timeStamp = httpServerRequest.getHeader("timeStamp");
        String sign = httpServerRequest.getHeader("sign");
        //TODO 应当去数据库中查 是否已经分配给用户
        if (!accessKey.equals("shuang")){
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce)> 100000 ) {
            throw new RuntimeException("无权限");
        }
        //TODO 实际从数据库中查询secretKey
        String serverSigh = SignUtils.genSign(body, "asdfghjkl");
        if (!sign.equals(serverSigh)) {
            throw new RuntimeException("无权限");
        }
        return "用户名字是Post" + user.getUserName();
    }
}
