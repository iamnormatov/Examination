package com.example.validation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class Schedule {
    @Scheduled(fixedDelay = 6, initialDelay = 2, timeUnit = TimeUnit.SECONDS)
    private void print(){
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
