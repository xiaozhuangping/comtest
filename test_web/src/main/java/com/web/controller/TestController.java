package com.web.controller;
import com.web.service.Testmates;
import com.web.vo.Classmates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.JedisCluster;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * 作者 ：xiaozhuangping[412948751@qq.com]
 * 时间 ：2017/2/5 14:21
 * 用途 ：
 */
@Controller
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private Testmates testmates;

    /*@Autowired
    RedisTemplate<String, String> redisTemplate;*/

    @Autowired
    JedisCluster jedisCluster;

    @RequestMapping("/{key}/{value}")
    public String newClassmates(Model model, @PathVariable("key") String key,@PathVariable("value") String value){
       /* logger.info("进入newClassmates控制器");
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        //数据插入测试：
        opsForValue.set(key, value);
        String valueFromRedis = opsForValue.get(key);
        logger.info("redis value after set: {}", valueFromRedis);
        assertThat(valueFromRedis, is(value));*/
        jedisCluster.set(key,value);

        Classmates classmates = new Classmates();
        classmates.setBirthday(new Date());
        classmates.setHobbies("看着我");
        classmates.setName("小");
        testmates.insert(classmates);
        model.addAttribute("name","装瓶");
        model.addAttribute("user",classmates);
        return "index";
    }
}
