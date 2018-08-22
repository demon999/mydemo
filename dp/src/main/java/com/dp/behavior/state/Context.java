package com.dp.behavior.state;

public class Context {
    private State state;

    public String stateMessage() {
        return this.state.getState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
