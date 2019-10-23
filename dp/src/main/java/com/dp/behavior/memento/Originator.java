package com.dp.behavior.memento;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 18:38
 */
public class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
