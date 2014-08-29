package com.snow.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Richard Xue on 14-8-1.
 */
@Component("studentPublisher")
public class StudentPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void addStudent(String content){
        StudentAddEvent studentAddEvent = new StudentAddEvent(this,content);
        applicationEventPublisher.publishEvent(studentAddEvent);
    }


}
