package com.dp.behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-23 18:39
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
