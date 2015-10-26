package com.xxx.serial;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/26/2015
 * @description
 */
public class KryoSample {
    public static void main(String[] args) {

    }

    public void test() throws FileNotFoundException {
        Kryo kryo = new Kryo();
        // ...
        Output output = new Output(new FileOutputStream("file.bin"));
        Object someObject = "1111";
        kryo.writeObject(output, someObject);
        output.close();
        // ...
        Input input = new Input(new FileInputStream("file.bin"));
        Object someObject2 = kryo.readObject(input, String.class);
        input.close();
    }
}
