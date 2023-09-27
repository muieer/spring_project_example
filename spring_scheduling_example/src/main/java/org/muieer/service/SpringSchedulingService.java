package org.muieer.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.muieer.config.SchedulingConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpringSchedulingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringSchedulingService.class);

    @Resource
    TaskScheduler taskScheduler;
    @Resource
    SchedulingConfiguration schedulingConfiguration;

    public void addJob(String jobContent, String cornExpression) {
        taskScheduler.schedule(
                () -> LOGGER.info("job content is {}, execution time is {}", jobContent, new Date()),
                new CronTrigger(cornExpression)
        );
    }

    @PostConstruct
    void init() throws InterruptedException {
        schedulingConfiguration.asyncRun();
        LOGGER.info("异步调用 schedulingConfiguration asyncRun 方法");
    }

}
