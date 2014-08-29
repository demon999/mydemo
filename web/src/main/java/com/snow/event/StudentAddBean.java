package com.snow.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Richard Xue on 14-8-1.
 */
@Component("studentAddBean")
public class StudentAddBean implements ApplicationContextAware {

    /**
     * 定义Spring上下文对象
     */
    private ApplicationContext applicationContext = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 增加一个学生
     *
     * @param _sStudentName
     */
    public void addStudent(String _sStudentName) {
        // 1.构造一个增加学生的事件
        StudentAddEvent aStudentEvent = new StudentAddEvent(applicationContext, _sStudentName);
        // 2.触发增加学生事件
        applicationContext.publishEvent(aStudentEvent);
    }

//    public static void main(String[] args) {
//        String[] xmlConfig = new String[]{"applicationContext.xml"};
//        // 使用ApplicationContext来初始化系统
//        ApplicationContext context = new ClassPathXmlApplicationContext(xmlConfig);
//        StudentAddBean studentBean = (StudentAddBean) context.getBean("studentAddBean");
//        studentBean.addStudent("我是第一个学生");
//        studentBean.addStudent("第二个学生已经添加");
//    }

}
