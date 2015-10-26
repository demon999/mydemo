package com.xxx.serial;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/26/2015
 * @description
 */
public class KryoRegistration {
    public void test() {
        Kryo kryo = new Kryo();
        kryo.register(String.class);
        // ...
//        Output output = ...
//        SomeClass someObject = ...
//        kryo.writeObject(output, someObject);
    }
}
