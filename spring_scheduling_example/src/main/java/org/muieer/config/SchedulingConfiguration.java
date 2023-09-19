package org.muieer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/*
* official document：https://docs.spring.io/spring-framework/reference/integration/scheduling.html
* */

@Configuration
@EnableAsync
@EnableScheduling
public class SchedulingConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingConfiguration.class);

    @Async
    public void asyncRun() throws InterruptedException {
        Thread.sleep(10000);
        LOGGER.info("SchedulingConfiguration asyncRun 方法异步调用执行结束");
    }

    // 每分钟的第 15 到 30 秒会执行，间隔 10 秒执行一次，会在第 15、25 秒调度
    @Scheduled(cron = "15-30/10 * * * * *")
    public void periodRun() {
        LOGGER.info("执行时间是：" + new Date());
    }

}
