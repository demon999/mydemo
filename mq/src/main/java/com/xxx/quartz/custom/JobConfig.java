package com.xxx.quartz.custom;

import org.quartz.Trigger;

import java.io.Serializable;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/15/2015
 * @description
 */
public class JobConfig implements Serializable {
    private String jobKey;
    private String jobGroup;
    private String triggerKey;
    private String triggerGroup;
    private Trigger trigger;

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getTriggerKey() {
        return triggerKey;
    }

    public void setTriggerKey(String triggerKey) {
        this.triggerKey = triggerKey;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }
}
