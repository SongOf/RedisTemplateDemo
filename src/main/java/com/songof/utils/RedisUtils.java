package com.songof.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author SongOf
 * @ClassName RedisUtils
 * @Description
 * @Date 2021/4/9 20:17
 * @Version 1.0
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void expire(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}
