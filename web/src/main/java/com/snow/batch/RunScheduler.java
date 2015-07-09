package com.snow.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/09/2015
 * @description
 */
@Component
public class RunScheduler {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    public void run() {
        try {
            String dateParam = new Date().toString();
            JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
            System.out.println(dateParam);
            JobExecution execution = jobLauncher.run(job, param);
            System.out.println("Exit Status : " + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
    }
}
