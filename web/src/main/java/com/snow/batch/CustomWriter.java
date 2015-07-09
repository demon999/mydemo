package com.snow.batch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/09/2015
 * @description
 */
public class CustomWriter implements ItemWriter<Report> {
    @Override
    public void write(List<? extends Report> list) throws Exception {
        System.out.println("writer..." + list.size());
        for(Report item : list){
            System.out.println(item);
        }
    }
}
