package com.example.redisCacheTest.service.serviceImpl;

import com.example.redisCacheTest.dto.request.RedisCacheRequest;
import com.example.redisCacheTest.dto.response.RedisCacheResponse;
import com.example.redisCacheTest.service.IRedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheServiceImpl implements IRedisCacheService {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class.getSimpleName());

    @Autowired
    private RedisTemplate template;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${quickstart.events}")
    private String quickstartEvents;

    @Override
    public boolean addValueInRedis(RedisCacheRequest redisCacheRequest) throws Exception{
        try {
            kafkaTemplate.send(quickstartEvents, redisCacheRequest);
        } catch (Exception ex){
            logger.error(ex.toString(), ex);
            throw new Exception(ex.getMessage());
        }
        return true;
    }

    @Override
    public RedisCacheResponse getValueFromRedis(String name) {
        String age = (String) template.opsForValue().get(name);
        RedisCacheResponse redisCacheResponse = new RedisCacheResponse();
        redisCacheResponse.setAge(Integer.valueOf(age));
        redisCacheResponse.setName(name);
        return redisCacheResponse;
    }
}
