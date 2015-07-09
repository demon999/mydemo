package com.snow.batch;

import java.io.Serializable;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/09/2015
 * @description
 */
public class Report implements Serializable {
    private long id;
    private double flag;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFlag() {
        return flag;
    }

    public void setFlag(double flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
