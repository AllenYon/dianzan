package com.alin.job;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class LikesNumSaveTask {

    @Scheduled(cron = "*/5 * * * * *")
    public void save() {
        System.out.println("run... ");
    }
}
