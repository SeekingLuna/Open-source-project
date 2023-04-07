package com.li;


import java.util.Scanner;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        start();

    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                while (true) {
                    String s = scanner.next();
                    System.out.println(lengthOfLongestSubstring(s));
                }
            case 2:
                while (true) {
                    String s = scanner.next();
                    System.out.println(method(s));

                }
        }
    }

    public static int method(String s) {
        int answer = 0;
        int length = s.length();

        int[] ints = new int[256];

        int left = 0, right = 0;

        while (right < length) {
            ints[s.charAt(right)]++;//这里的right是个int 而不是 char，要注意
            while (ints[s.charAt(right)] > 1) {

                ints[s.charAt(left)]--;
                left++;

            }
            answer = Math.max(answer, right - left + 1);
            right++;


        }
        return answer;

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0, right = 0;
        int[] freq = new int[256]; // 记录每个字符出现的次数

        while (right < n) {
            char c = s.charAt(right);
            freq[c]++;

            while (freq[c] > 1) { // 如果出现重复字符，移动左边界
                char d = s.charAt(left);
                freq[d]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }


}
