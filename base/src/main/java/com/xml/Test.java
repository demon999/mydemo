package com.xml;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-06 23:56
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(5 ^ 0);

        Set<Short> sets = new HashSet<>(100);
        for (int i = 0; i < 100; i++) {
            sets.add((short)i);
            sets.remove((short)(i-1));
        }
        System.out.println(sets.size());


    }

}
