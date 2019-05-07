package com.dyh.array;

import java.util.Arrays;

/**
 * Array Partition I：一个数组有2n个元素，现在需要将这些数分成n组，然后从每一组里取出最小的数字，把所以的数加起来，使这个数最大。
 * 例：[1,4,3,2]
 * 返回：4
 * @author dyh
 *
 */

public class ArrayPartionI {
	
	//根据题意，我们只需要让每一组的两个数尽可能接近，那么获得的数就能最大
	//我们先把nums sort 一下，让它从小到大排列，接着每次把index： 0， 2， 4...偶数位的数字加起来就可以了。
	public static int arrayPairSum(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int sum = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i+=2) {
			sum += nums[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 4, 3, 2};
		System.out.println(arrayPairSum(nums));
	}

}
