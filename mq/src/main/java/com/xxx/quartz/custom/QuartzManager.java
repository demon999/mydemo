package com.xxx.quartz.custom;

import org.quartz.SchedulerException;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/15/2015
 * @description
 */
public interface QuartzManager {
    public void addJob(JobConfig config) throws SchedulerException;
    public void modifyJob(JobConfig config);
    public void resumeJob(JobConfig config);
    public void pauseJob(JobConfig config);
    public void removeJob(JobConfig config);
    public void resumeAll() throws SchedulerException;
    public void pauseAll() throws SchedulerException;
}
