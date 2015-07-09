package com.snow.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Random;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/09/2015
 * @description
 */
public class CustomReader implements ItemReader<Report> {
    private static Logger logger = LoggerFactory.getLogger(CustomReader.class);
    private final static Random random = new Random();
    @Override
    public Report read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        double flag = random.nextDouble();
        logger.info("flag >>>>> "+flag);
        if(flag < 0.5) {
            return null;
        }
        Report report = new Report();
        long id = random.nextLong();
        report.setId(id);
        report.setFlag(flag);
        report.setName("report_"+id);
        logger.info(report.getId()+"||"+report.getName());
        return report;
    }
}
