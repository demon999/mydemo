package com.xxx.quartz.custom;

import org.quartz.SchedulerException;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/15/2015
 * @description
 */
public interface QuartzManager {
    void addJob(JobConfig config) throws SchedulerException;
    void modifyJob(JobConfig config) throws SchedulerException;
    void resumeJob(JobConfig config) throws SchedulerException;
    void pauseJob(JobConfig config) throws SchedulerException;
    void deleteJob(JobConfig config) throws SchedulerException;
    void resumeAll() throws SchedulerException;
    void pauseAll() throws SchedulerException;
}
