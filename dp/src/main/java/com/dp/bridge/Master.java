package com.dp.bridge;

/**
 * Created by Administrator on 14-6-24.
 */
public class Master extends Student {
    @Override
    public void doPlay(Play play) {
        System.out.println("Master---->");
        play.play();
    }
}
