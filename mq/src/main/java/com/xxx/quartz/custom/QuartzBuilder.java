package com.xxx.quartz.custom;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Trigger;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/15/2015
 * @description
 */
public interface QuartzBuilder {
    Job buildJob();
    JobDetail buildJobDetail();
    Trigger buildTrigger();
}
