package com.xml;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

        System.out.println(seats.size() + " >>> " + getPos(2));
    }

    private static final List<Integer> seats = Arrays.asList(1,3,5,2,7,8,1,4,5,2,2,1);

    public static int getPos(int x) {
        int pos = 0;
        int min = 0;
        int minTemp = 0;
        for (int i = 0; i < seats.size(); i++) {
            if (i < x) {
                min += seats.get(i);
                minTemp = min;
            } else {
                minTemp = minTemp + seats.get(i) - seats.get(i - x);
                if (minTemp < min) {
                    pos = i;
                    min = minTemp;
                }
            }
        }
        return pos;
    }

}
