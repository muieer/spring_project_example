package org.muieer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableAsync
@EnableScheduling
public class SchedulingConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingConfiguration.class);

    @Async
    public void asyncRun() throws InterruptedException {
        Thread.sleep(10000);
        LOGGER.info("SchedulingConfiguration asyncRun 方法调用执行结束");
    }

    @Scheduled(cron = "30-59 * * * * *")
    public void periodRun() {
        LOGGER.info(new Date().toString());
    }

}
