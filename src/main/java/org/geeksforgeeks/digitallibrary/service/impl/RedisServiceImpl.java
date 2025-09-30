package org.geeksforgeeks.digitallibrary.service.impl;

import org.geeksforgeeks.digitallibrary.dto.SaveInRedisCacheDto;
import org.geeksforgeeks.digitallibrary.service.core.IRedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements IRedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public String save(SaveInRedisCacheDto dto) {
        this.redisTemplate.opsForValue().set(dto.getKey(), dto.getValue(),10, TimeUnit.MINUTES);
        return "Key " + dto.getKey() + " saved in cache with value " + dto.getValue() + " For 10 Minutes";
    }

    @Override
    public String get(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }
}
