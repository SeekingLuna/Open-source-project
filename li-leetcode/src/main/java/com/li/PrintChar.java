package com.li;

import java.util.Scanner;

/**
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 */
public class PrintChar {
    public static void main(String[] args) {
        start();
    }

    public static void start() {

        while (true) {

            print();


        }


    }

    public static void print() {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();//需要打印的*数量
        //现在计算打印多少*
        int max = 1;//max为底上*的数量
        int used = 1;//user为当前已使用的*的数量
        int high = 1;//hith为沙漏的高的一半
        while ((used + 2 * (max + 2)) <= total) {
            used = used + 2 * (max + 2);
            max = max + 2;
            high++;

        }
        System.out.println("used:" + used + " max:" + max + " high:" + high);
        //现在开始打印沙漏的上半部分
        int now = 1;
        for (int i = high; i >= 1; i--) {//i是当前层高
            //被打印层的*数目
            now = 2 * i - 1;

            //先打印空格
            for (int j = 0; j < (max - now) / 2; j++) {
                System.out.print(" ");
            }
            //再打印“*”
            for (int j = 1; j <= now; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //现在打印下半部分
        for (int i = 2; i <= high; i++) {
            now = 2 * i - 1;
            //先打印空格
            for (int j = 0; j < (max - now) / 2; j++) {
                System.out.print(" ");

            }
            //现在打印*
            for (int j = 1; j <= now; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("total-used= " + (total - used));

    }
}


//public class PrintChar {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt(); // 符号总数
//        int h = 1; // 沙漏的底的*数量
//        int count = 1; // 当前已使用的符号数量
//
//        // 计算沙漏的底的符号数量和已经使用的符号数量
//        while (count + 2 * (h + 2) <= n) {
//            h = h + 2; // 沙漏高度每次增加2个符号
//            count = count + 2 * h; // 当前已使用的符号数量增加2h个符号
//        }
//
//        // 打印沙漏的上半部分
//        for (int i = h; i >= 1; i = i - 2) { // 从沙漏最大高度开始，每次减2
//            int k = (h - i) / 2; // 计算需要打印的空格数
//            for (int j = 0; j < k; j++) {
//                System.out.print(" "); // 打印空格
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.print("*"); // 打印符号
//            }
//            System.out.println(); // 换行
//        }
//
//        // 打印沙漏的下半部分
//        for (int i = 3; i <= h; i = i + 2) { // 从3开始，每次增加2
//            int k = (h - i) / 2; // 计算需要打印的空格数
//            for (int j = 0; j < k; j++) {
//                System.out.print(" "); // 打印空格
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.print("*"); // 打印符号
//            }
//            System.out.println(); // 换行
//        }
//
//        // 输出未使用的符号数量
//        System.out.println(n - count);
//    }
//}