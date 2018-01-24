package com.dyh.binarySearch;

import java.math.BigInteger;

/**
 *  快速N次方练习题：如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，
 *  得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 *  给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 *  例： 2，3
 *  返回： 8
 *  思路：将n变成二进制
 * @author dyh
 *
 */

public class QuickPower {  
    public static int getPower(int k, int n) {
    	BigInteger res = BigInteger.valueOf(1);
    	BigInteger tmp = BigInteger.valueOf(k);
    	for(; n != 0; n >>= 1) {
    		if((n & 1) != 0) {
    			//multiply阶乘
    			res = res.multiply(tmp);
    		}
    		tmp = tmp.multiply(tmp);
    		res = res.mod(BigInteger.valueOf(1000000007));
    		tmp = tmp.mod(BigInteger.valueOf(1000000007));
    		
    	}
    	return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 2;
		System.out.println(getPower(2, 3));
	}

}
