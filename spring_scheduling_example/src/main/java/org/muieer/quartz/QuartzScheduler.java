package org.muieer.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class QuartzScheduler {

    public void run() throws Exception {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder
                .newJob(PrintJob.class)
                .usingJobData("name", "muieer")
                .withIdentity("printJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("printTrigger", "group1")
                // 每三秒执行一次
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3))
                .startAt(Date.from(LocalDateTime.now().plusSeconds(5L).atZone(ZoneId.systemDefault()).toInstant()))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws Exception {
        new QuartzScheduler().run();
    }
}
