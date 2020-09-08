package com.peppermint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peppermint.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.data.redis.AutoConfigureDataRedis;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//        redisTemplate.opsForValue().set(""); 操作string类型
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        redisTemplate.opsForValue().set("mykey", "welcome you!");
//        System.out.println(redisTemplate.opsForValue().get("mykey"));

        // 真实的开发中一般都用json来传递对象
        User user = new User("hh", "123");
        try {
            String jsonUser = new ObjectMapper().writeValueAsString(user);
            redisTemplate.opsForValue().set("user",jsonUser); // 所有对象都需要序列化
            System.out.println(redisTemplate.opsForValue().get("user"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
