package com.example.redisCacheTest.controller;

import com.example.redisCacheTest.dto.request.RedisCacheRequest;
import com.example.redisCacheTest.dto.response.RedisCacheResponse;
import com.example.redisCacheTest.service.IRedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisCacheController {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheController.class.getSimpleName());

    @Autowired
    private IRedisCacheService redisCacheService;

    @PostMapping("/")
    public boolean addValueInRedis(@RequestBody RedisCacheRequest redisCacheRequest){
       try {
           return redisCacheService.addValueInRedis(redisCacheRequest);
       } catch (Exception ex){
           logger.error(ex.toString(), ex);
       }
       return false;
    }

    @GetMapping("/{name}")
    public RedisCacheResponse getValuefromRedis(@PathVariable(value = "name") String name) throws Exception{
        try{
            return redisCacheService.getValueFromRedis(name);
        } catch (Exception ex){
            logger.error(ex.toString(), ex);
            throw new Exception(ex.getMessage());
        }
    }

}
