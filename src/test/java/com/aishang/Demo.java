package com.aishang;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: jiangyu
 * @Date: 2019/7/10 9:38
 * @Description:
 */
public class Demo {

    @Test
    public void fun1(){
        //开启连接
        Jedis jedis = new Jedis("localhost", 6379);
        //切换库（默认0库）
        jedis.select(1);
        //存放数据
        jedis.set("hello", "你好啊");
        //获取数据
        String string = jedis.get("hello");
        //输出打印12321
        System.out.println(string);
        //回收资源
        jedis.close();
    }

    @Test
    public void fun2(){
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.select(1);
        //存放数据
        jedis.set("hello2", "你好啊2");
        //获取数据
        String string = jedis.get("hello");
        //输出打印
        System.out.println(string);
        //回收资源
        jedis.close();
        jedisPool.close();
    }
}
