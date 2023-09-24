package org.muieer.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintJob implements Job {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String name;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("执行时间是：" + formatter.format(LocalDateTime.now()));
        System.out.println("hello " + name);
    }

    /*
    * 等价于 <code>name = context.getJobDetail().getJobDataMap().getString("name");</code>
    * @see  <a href="http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/tutorial-lesson-03.html">JobDataMap</a>
    * */
    public void setName(String name) {
        this.name = name;
    }
}
