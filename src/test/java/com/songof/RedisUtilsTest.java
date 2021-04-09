package com.songof;

import com.songof.utils.RedisUtils;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author SongOf
 * @ClassName RedisUtilsTest
 * @Description
 * @Date 2021/4/9 20:30
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {

    @Resource
    private RedisUtils redisUtils;

    @Test
    public void test() {
        redisUtils.set("name", "Song");
        System.out.println(redisUtils.get("name"));
        redisUtils.delete("name");
    }
}
