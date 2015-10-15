package com.xxx.quartz.sample;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/15/2015
 * @description
 */
public class QuartzTest {
    public static void main(String[] args) {
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our HelloJob class
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();
            // Trigger the job to run now, and then repeat every 40 seconds
//            Trigger trigger = TriggerBuilder.newTrigger()
//                    .startNow()
//                    .withSchedule(simpleSchedule()
//                            .withIntervalInSeconds(40)
//                            .repeatForever())
//                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startAt(new Date())
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
