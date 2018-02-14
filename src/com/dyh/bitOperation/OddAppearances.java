package com.dyh.bitOperation;

import java.util.Arrays;

/**
 * 寻找奇数出现练习题2:给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 * 例：[1,2,4,4,2,1,3,5],8
 * 返回：[3,5]
 * 思路：利用异或
 * @author dyh
 *
 */

public class OddAppearances {
	
	public static int[] findOdds(int[] arr, int n) {
        // write code here
		int e0 = 0, e0hasOne = 0;
		for(int i = 0; i < n; i++) {
			e0 ^= arr[i];
		}
		//此时e0 等于两个奇数异或的值
		int rightOne = e0 & (~e0 + 1);
		for(int i = 0; i < n; i++) {
			if((arr[i] & rightOne) != 0) {
				//只与arr中第k位为1的那些整数进行异或
				e0hasOne ^= arr[i];
			}
		}
		int small = Math.min(e0hasOne,  (e0^e0hasOne));
		int big = Math.max(e0hasOne,  (e0^e0hasOne));
		return new int[] {small, big};
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,4,2,1,3,5};
		System.out.println(Arrays.toString(findOdds(arr, 8)));
	}

}
