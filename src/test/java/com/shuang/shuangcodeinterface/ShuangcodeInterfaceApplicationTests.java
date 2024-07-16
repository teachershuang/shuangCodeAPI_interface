package com.shuang.shuangcodeinterface;

import com.shuang.shuangcodeclientsdk.client.ShuangCodeClient;
import com.shuang.shuangcodeclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShuangcodeInterfaceApplicationTests {


    @Resource
    private ShuangCodeClient shuangCodeClient;


    @Test
    void contextLoads() {
        String nameUsingGet = shuangCodeClient.getNameUsingGet("shuang");
        String nameUsingPost = shuangCodeClient.getNameUsingPost("shuang");
        User user = new User();
        user.setUserName("shuang");
        String userNameUsingPost = shuangCodeClient.getUserNameUsingPost(user);
        System.out.println(nameUsingGet);
        System.out.println(nameUsingPost);
        System.out.println(userNameUsingPost);
    }

}
