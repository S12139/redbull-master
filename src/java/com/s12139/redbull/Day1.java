package com.s12139.redbull;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day1 {
    /**
     * @param num
     * @return
     */
    public String largestGoodInteger(String num) {
        char[] numChar = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<Character> c = new ArrayList<>();
        boolean matchf = false;
        for (int i = 0; i < numChar.length - 2; i++) {
            if (numChar[i] == numChar[i + 1] && numChar[i + 1] == numChar[i + 2]) {
                if (matchf) {
                    if (c.get(0) < numChar[i]) {
                        c.clear();
                        c.add(numChar[i]);
                    }
                } else {
                    matchf = true;
                    c.add(numChar[i]);
                }
            }
        }
        if (!c.isEmpty()) {
            sb.append(c.get(0)).append(c.get(0)).append(c.get(0));
        }
        return sb.toString();
    }

    @Test
    public void test3Char() {
        System.out.println("output :-" + largestGoodInteger("2444300019555"));
        System.out.println("output :-" + largestGoodInteger("2300019"));
        System.out.println("output :-" + largestGoodInteger("42352338"));
    }

    /**
     * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
     * <p>
     * A substring is a contiguous sequence of characters within a string.
     * <p>
     */
    public String largestOddInteger(String num) {
        char[] numChar = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean find = false;
        for (int i = num.length()-1; i>0; i--) {
            Character ch = new Character(numChar[i]);
            if (Character.isDigit(ch) && (((int) ch) % 2 != 0) && !find) {
                sb.append(num.substring(0,i+1));
                find = true;
            }
        }
        return sb.toString();
    }

    @Test
    public void testOddChar() {
        System.out.println("output :-" + largestOddInteger("2444300019555"));
        System.out.println("output :-" + largestOddInteger("2300019"));
        System.out.println("output :-" + largestOddInteger("42352338"));
        System.out.println("output :-" + largestOddInteger("4244222222222"));
        System.out.println("output :-" + largestOddInteger("423523382849374398574359435743987457439574574359875437857435757584388888888888888888888"));
    }

    /**
     * Easy
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     */

    public int[] twoSum(int[] nums, int target) {
        int[] finaInt = new int[2];
        for (int i = 0; i< nums.length-1;i++){
            for(int j = i+1; j<=nums.length-1;j++) {
                if (target == (nums[i] + nums[j])) {
                    finaInt[0] = i;
                    finaInt[1] = j;
                }
            }
        }
        return finaInt;
    }

    @Test
    public void testTwoSum(){
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,4},6)));
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,3},6)));
    }


}
