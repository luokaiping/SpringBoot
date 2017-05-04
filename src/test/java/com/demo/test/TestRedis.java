package com.demo.test;

import redis.clients.jedis.Jedis;

import java.util.Scanner;

/**
 * Created by lWX458933 on 2017/5/2.
 */
public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.160.142.133");
        Scanner in = new Scanner(System.in);
        while (true) {
            String name = in.next();
            String value = jedis.get(name);
            System.out.println(value);
        }
    }
}
