//package com.li;
//
//
//
//
//import javax.security.auth.login.CredentialNotFoundException;
//import java.util.List;
//
//class Solution2 {
//    int[] nums;
//         static List  <Integer> list = new List;
//    int k;
//
//    public static void main(String[] args) {
//        Solution2 solution2=new Solution2();
//        List<Integer> result=  solution2.method(1,list);
//
//
//    }
//
//
//
//
//
//
//    public int foreach(List<Integer> list) {
//
//
//        return 1;
//    }
////得到斜率的数组
//    public List<Integer> method(int index, List<Integer> result,List<Integer> nums) {
//
//        while (index <= nums.size() - 1) {
//
//            k = (nums[index] - nums[index - 1]) / 1;
//            list.add(k);
//            method(index + 2, list);
//        }
//        return list;
//    }
//}