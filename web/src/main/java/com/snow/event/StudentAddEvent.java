package com.snow.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Richard Xue on 14-8-1.
 */
public class StudentAddEvent extends ApplicationEvent {

    private String m_sStudentName;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public StudentAddEvent(Object source, String m_sStudentName) {
        super(source);
        this.m_sStudentName = m_sStudentName;
    }

    public String getStudentName() {
        return m_sStudentName;
    }
}
