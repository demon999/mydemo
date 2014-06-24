package com.dp.bridge;

/**
 * Created by Administrator on 14-6-24.
 * 主要特点是把抽象（abstraction）与行为实现（implementation）分离开来，
 * 从而可以保持各部分的独立性以及应对它们的功能扩展。
 */
public class Cilent {
    public static void main(String[] args) {
        Student student = new Bachelor();
        student.doPlay(new Football());
    }
}
