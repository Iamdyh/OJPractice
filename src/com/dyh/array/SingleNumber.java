package com.dyh.array;

/**
 * Single Number:Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 例：[2, 2, 1]
 * 返回：1
 * @author dyh
 *
 */

public class SingleNumber {
	
	//异或同一个数两次，原数不变
	public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
        	res ^= nums[i];
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,1};
		System.out.println(singleNumber(nums));
	}

}
