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
    public void modifyJob(JobConfig config) throws SchedulerException;
    public void resumeJob(JobConfig config) throws SchedulerException;
    public void pauseJob(JobConfig config) throws SchedulerException;
    public void deleteJob(JobConfig config) throws SchedulerException;
    public void resumeAll() throws SchedulerException;
    public void pauseAll() throws SchedulerException;
}
