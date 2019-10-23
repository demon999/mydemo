package com.dp.behavior.memento;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 18:37
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
