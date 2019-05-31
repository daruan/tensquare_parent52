package com.tensquare.gathering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * Created by daruan on 2019/5/31.
 */
@SpringBootApplication
@EnableCaching  //开启springboot自带缓存,比redis功能弱 配合@cacheable、@cacheevict使用
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
