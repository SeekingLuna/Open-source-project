package com.li;

import java.util.Arrays;

class Solution {


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        Solution solution = new Solution();
        System.out.println("length=" + solution.removeDuplicates(nums2));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        for (int num : nums) {
            System.out.print(num);
        }
        return pointer;
    }
}


//    public int removeDuplicates(int[] nums) {
//        int count = 0;
//        int oldNumber;
//        int newNumber;
//        int times = 0;
//        int specialValue = Integer.MIN_VALUE;
//
//        for (int i = 1; i < nums.length; i++) {
//            oldNumber = nums[i - 1];
//            newNumber = nums[i];
//            if (newNumber == oldNumber) {
//                count++;
//
//            } else if (count > 1) {
//                nums[i] = specialValue;
//                count = count - 1;
//            }
//
//
//        }
//
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]==specialValue) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    nums[j - 1] = nums[j];
//                }
//                nums = Arrays.copyOf(nums, nums.length - 1);
//            }
//        }
//        for (int num : nums) {
//            System.out.print(num);
//        }
//
//        return nums.length;
//    }


//        for (int i = 1; i < nums.length; i++) {
//            oldNumber = nums[i - 1];
//            newNumber = nums[i];
//            if (newNumber == oldNumber) {
//                count++;
//                if ((count > 1) && (nums[i + 1] != nums[i])) {
//                    for (int j = i + 1; j < nums.length; j++) {
//                        nums[j - 1] = nums[j];
//                    }
//                    nums = Arrays.copyOf(nums, nums.length - 1);
//                    count = 0;
//                } else {
//                 while  ((count > 1) && (nums[i + 1] == nums[i])) {
//                     for (int j = i + 1; j < nums.length; j++) {
//                         nums[j - 1] = nums[j];
//                     }
//                     nums = Arrays.copyOf(nums, nums.length - 1);
//                    }
//
//
//                    count=0;
//                }
//
//            } else {
//                count = 0;
//            }
//        }
