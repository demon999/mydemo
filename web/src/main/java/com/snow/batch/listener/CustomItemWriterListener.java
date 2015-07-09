package com.snow.batch.listener;

import com.snow.batch.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/09/2015
 * @description
 */
public class CustomItemWriterListener implements ItemWriteListener<Report> {
    private static Logger logger = LoggerFactory.getLogger(CustomItemWriterListener.class);
    @Override
    public void beforeWrite(List<? extends Report> list) {
        System.out.println("CustomItemWriterListener - beforeWrite");
    }

    @Override
    public void afterWrite(List<? extends Report> list) {
        System.out.println("CustomItemWriterListener - afterWrite");
    }

    @Override
    public void onWriteError(Exception e, List<? extends Report> list) {
        System.out.println("CustomItemWriterListener - onWriteError");
    }
}
