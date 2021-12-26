package com.example.redisCacheTest.service;

import com.example.redisCacheTest.dto.request.RedisCacheRequest;
import com.example.redisCacheTest.dto.response.RedisCacheResponse;

public interface IRedisCacheService {

    boolean addValueInRedis(RedisCacheRequest redisCacheRequest) throws Exception;

    RedisCacheResponse getValueFromRedis(String id);
}
