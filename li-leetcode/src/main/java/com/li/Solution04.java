package com.li;

import java.util.ArrayList;

public class Solution04 {


    public static void main(String[] args) {


        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        Solution04 solution04 = new Solution04();
        int [] ints= solution04.vowelStrings(words,queries);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] result = new int[queries.length];
        int start;
        int end;
        int count = 0;
        for (int j = 0; j < queries.length; j++) {
            start = queries[j][0];
            end = queries[j][1];

            for (int k = start; k <= end; k++) {
                if (isStartOrEndWith(words[k])) {

                    count++;

                }


            }
            result[j] = count;
            count = 0;
        }

        return result;

    }

    public static boolean isStartOrEndWith(String s) {
        return (


                (    s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u"))
        &&(s.endsWith("a") || s.endsWith("e") || s.endsWith("i") || s.endsWith("o") || s.endsWith("u"))

        );

    }

}
