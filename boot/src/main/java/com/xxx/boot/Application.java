package com.xxx.boot;

import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import com.xxx.boot.jarslink1.ModuleRefreshSchedulerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by Richard on 14-8-26.
 */
@SpringBootApplication
@ComponentScan
public class Application {
    @Bean
    public ModuleLoader moduleLoader() {
        return new ModuleLoaderImpl();
    }

    @Bean
    public ModuleManager moduleManager() {
        return new ModuleManagerImpl();
    }

    @Bean
    public ModuleRefreshSchedulerImpl moduleRefreshScheduler () {
        return new ModuleRefreshSchedulerImpl();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);


        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }


        ModuleManager moduleManager = ctx.getBean(ModuleManager.class);
        //查找模块
        Module findModule = moduleManager.find("demo");
        //查找和执行
        String actionName = "helloworld";
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("h");
        moduleConfig.setEnabled(true);
        ModuleConfig result = findModule.doAction(actionName, moduleConfig);


    }

}
