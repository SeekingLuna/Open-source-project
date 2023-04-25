package com.li;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Solution3 {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(generate(1));
    }
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return result;
        }
        List<Integer> row = new ArrayList<>();
        if (result.isEmpty()) {
            row.add(1);
            result.add(row);
        } else {
            List<Integer> lastRow = result.get(result.size()-1);
            for (int i = 0; i <= lastRow.size(); i++) {
                if (i == 0 || i == lastRow.size()) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(i-1) + lastRow.get(i));
                }
            }
            result.add(row);
        }
        generate(numRows-1);
        return result;
    }
}
//public class Solution03 {
//    static int count = 0;
//
//    static LinkedList<LinkedList<Integer>> result = new LinkedList<>();
//
//    public static void main(String[] args) {
//
//        LinkedList<Integer> list = new LinkedList<>();
//
//
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        method2(10, 1, list);
//        System.out.println(result.toString());
//    }
//
//
//    public static void method2(int numRows, int myNumRows, LinkedList<Integer> integerLinkedList) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        while (count <= numRows) {
//            for (int i = 1; i <= myNumRows; i++) {
//                if (i == 1 || i == myNumRows) {
//
//                    linkedList.add(1);
//
//                } else {
//                    linkedList.add(integerLinkedList.get(i - 1) + integerLinkedList.get(i));
//                }
//
//
//            }
//            result.add(linkedList);
//
//            count++;
//            myNumRows++;
//            method2(numRows, myNumRows, linkedList);
//        }
//
//
//    }}

//    public static void method(Integer numRows) {
//        LinkedList<LinkedList<Integer>> bigLinkedList = new LinkedList<>();
//
//        LinkedList<Integer> smallLinkedList = new LinkedList<>();
//
//        int smallLinkedlistSize = smallLinkedList.size();
//        int bigLinkedlistSize = bigLinkedList.size();
//
//        for (int i = 1; i <= numRows; i++) {
//
//            for (int j = 1; j < i; j++) {
//
//            }
//
//
//        }
//
//
//    }

