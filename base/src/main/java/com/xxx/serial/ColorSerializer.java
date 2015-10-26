package com.xxx.serial;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.awt.*;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 10/26/2015
 * @description
 */
public class ColorSerializer extends Serializer<Color> {
    @Override
    public void write(Kryo kryo, Output output, Color color) {
        output.writeInt(color.getRGB());
    }

    @Override
    public Color read(Kryo kryo, Input input, Class<Color> aClass) {
        return new Color(input.readInt(), true);
    }
}
