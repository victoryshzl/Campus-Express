package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author by HZL
 * @date 2019/11/29 10:25
 * @description 多任务执行
 */

@Service
public class ScheduleTask {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
    @Scheduled(cron = "${schedule.cron1}")
    public void execute() {
        logger.info("print word.");
        logger.info(String.valueOf(System.currentTimeMillis()));
        try{
            Thread.sleep(6000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Scheduled(cron = "${schedule.cron2}")
    public void execute1(){
        logger.info(String.valueOf(System.currentTimeMillis()));
        logger.info("write message.");
    }
}
