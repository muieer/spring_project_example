package org.muieer.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.DailyCalendar;

import java.time.Instant;
import java.util.Date;

public class QuartzScheduler {

    public void run() throws Exception {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        var startDate = Date.from(Instant.now().plusSeconds(5));
        // 该时间段不参与调度
        DailyCalendar calendar = new DailyCalendar(startDate.getTime() + 10000, startDate.getTime() + 20000);
        scheduler.addCalendar("calendar", calendar, false, false);

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
                .modifiedByCalendar("calendar")
                .startAt(startDate)
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws Exception {
        new QuartzScheduler().run();
    }
}
