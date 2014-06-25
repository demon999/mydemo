package com.dp.creational.prototype;

/**
 * Created by Administrator on 14-6-17.
 */
public class Prototype implements Cloneable {

    @Override
    protected Prototype clone() {
        Prototype prototype = null;
        try{
            prototype = (Prototype)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }
}
