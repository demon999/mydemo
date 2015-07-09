package com.snow.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/09/2015
 * @description
 */
public class CustomStepListener implements StepExecutionListener {
    private static Logger logger = LoggerFactory.getLogger(CustomStepListener.class);
    @Override
    public void beforeStep(StepExecution stepExecution) {
        logger.info("CustomStepListener - beforeStep");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info("CustomStepListener - afterStep");
        return null;
    }
}
