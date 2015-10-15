package com.xxx.quartz.custom;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/15/2015
 * @description
 */
@Component
public class SampleQuartzManager implements QuartzManager {

    @Resource
    private Scheduler scheduler;

    @Override
    public void addJob(JobConfig config) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(config.getJobKey(),config.getJobGroup());
        TriggerKey triggerKey = TriggerKey.triggerKey(config.getTriggerKey(), config.getTriggerGroup());
        if(scheduler.checkExists(jobKey) || scheduler.checkExists(triggerKey)) {

        } else {
//            scheduler.scheduleJob(buildJob(context), buildTrigger(context));
        }
    }

    @Override
    public void modifyJob(JobConfig config) throws SchedulerException {
        scheduler.rescheduleJob(TriggerKey.triggerKey(config.getTriggerKey(),config.getTriggerGroup()), config.getTrigger());
    }

    @Override
    public void resumeJob(JobConfig config) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(config.getJobKey(), config.getJobGroup()));
    }

    @Override
    public void pauseJob(JobConfig config) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(config.getJobKey(), config.getJobGroup()));
    }

    @Override
    public void deleteJob(JobConfig config) throws SchedulerException {
        scheduler.deleteJob(JobKey.jobKey(config.getJobKey(), config.getJobGroup()));
    }

    @Override
    public void resumeAll() throws SchedulerException {
        scheduler.resumeAll();
    }

    @Override
    public void pauseAll() throws SchedulerException {
        scheduler.pauseAll();
    }
}
