package com.dyh.bitOperation;

import java.util.Arrays;

/**
 * 交换练习题:请编写一个算法，不用任何额外变量交换两个整数的值。
 * 给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
 * 例：1，2
 * 返回：2，1
 * 思路：利用异或, n ^ n = 0, n ^ 0 = n
 * @author dyh
 *
 */

public class Swap {

	public static int[] getSwap(int[] num) {
        // write code here
		if(num == null || num.length < 2)
			return null;
		//设num[0] = a  = a0, num[1] = b = b0
		num[0] = num[0]^ num[1]; // 等价于 a= a0 ^ b0, b = b0;
		num[1] = num[0]^ num[1]; // 等价于 a= a0 ^ b0, b = a0 ^ b0 ^ b0 = a0; 
		num[0] = num[0]^ num[1]; // 等价于 a= a0 ^ a0 ^ b0 = b0, b = a0.
		return num;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2};
		System.out.println(Arrays.toString(getSwap(num)));
	}

}
