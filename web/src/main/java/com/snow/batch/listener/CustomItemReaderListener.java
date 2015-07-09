package com.snow.batch.listener;

import com.snow.batch.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/09/2015
 * @description
 */
public class CustomItemReaderListener implements ItemReadListener<Report> {
    private static Logger logger = LoggerFactory.getLogger(CustomItemReaderListener.class);
    @Override
    public void beforeRead() {
        logger.info("CustomItemReaderListener - beforeRead");
    }

    @Override
    public void afterRead(Report report) {
        logger.info("CustomItemReaderListener - afterRead");
    }

    @Override
    public void onReadError(Exception e) {
        logger.info("CustomItemReaderListener - onReadError");
    }
}
