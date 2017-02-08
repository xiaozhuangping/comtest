package com.dao.test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import java.util.HashSet;
import java.util.Set;

/**
 * 用途 ：
 * 时间 ： 2017/2/7.
 * 作者 ： xiaozhuangping
 * 邮箱 ： 412948751@qq.com
 */

public class Testredis {

    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("192.168.207.131",7000));
        JedisCluster jc = new JedisCluster(jedisClusterNodes,5000);
        jc.set("foo", "bar");
        String value = jc.get("foo");
        System.out.println(value);

        /*Jedis jedis = new Jedis("192.168.207.131",7003);
        System.out.println("Connection to server sucessfully");
        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");*/
    }

}
