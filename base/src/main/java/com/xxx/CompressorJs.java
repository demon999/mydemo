package com.xxx;

import com.yahoo.platform.yui.compressor.Bootstrap;

/**
 * Created by Richard on 14-11-30.
 */
public class CompressorJs {
    public static void main(String[] args) {
        String[] data = "--charset utf-8 --type js tools.js -o tools.min.js".split(" ");
        try {
            Bootstrap.main(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
