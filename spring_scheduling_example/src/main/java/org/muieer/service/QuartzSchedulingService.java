package org.muieer.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.muieer.quartz.PrintJob;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.TriggerBuilder.newTrigger;

@Service
public class QuartzSchedulingService {

    @Resource
    Scheduler quartzScheduler;

    @PostConstruct
    public void init() throws SchedulerException {

        var startDate = Date.from(Instant.now().plusSeconds(5));

        JobDetail jobDetail = newJob(PrintJob.class)
                .usingJobData("name", "muieer")
                .withIdentity("printJob", "group1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("printTrigger", "group1")
                // 每三秒执行一次
                .withSchedule(cronSchedule("0/5 * * * * ?"))
                .startAt(startDate)
                .build();

        quartzScheduler.scheduleJob(jobDetail, trigger);
        quartzScheduler.start();
    }
}
