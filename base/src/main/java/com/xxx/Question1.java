package com.xxx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-25 20:55
 */
public class Question1 {
    public static void main(String[] args) {
//        System.out.println(get("12345._"));
//        int[] a = {1, 3, 5};
//        int[] b = {2, 4, 6, 7};
//        Arrays.stream(merge(a, b)).forEach(System.out::println);

        System.out.println(1 << 14);
    }



    public static Character get(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        char[] chars = string.toLowerCase().toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (Character character : chars) {
            Integer count = charCountMap.get(character);
            charCountMap.put(character, count == null ? 1 : count + 1);
        }
        return charCountMap.entrySet().stream().sorted((a, b) -> {
            int compare = b.getValue() - a.getValue();
            if (compare != 0) {
                return compare;
            }
            return a.getKey() > b.getKey() ? 1 : -1;
        }).findFirst().get().getKey();
    }

    public static int[] merge(int[] a, int[] b) {
        if (b.length == 0) {
            return a;
        }

        int head = b[0];
        int[] c = new int[a.length + 1];

        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (flag) {
                c[i + 1] = a[i];
            } else if (a[i] <= head) {
                c[i] = a[i];
            } else {
                c[i] = head;
                flag = true;
                i--;
            }
        }
        if (!flag) {
            c[a.length] = head;
        }
        return merge(c, removeHead(b));
    }

    public static int[] removeHead(int[] b) {
        if (b.length <= 1) {
            return new int[0];
        }
        int[] c = new int[b.length-1];
        for (int i = 0; i < b.length - 1; i++) {
            c[i] = b[i + 1];
        }
//        Arrays.stream(c).forEach(System.out::println);
        return c;
    }

}
