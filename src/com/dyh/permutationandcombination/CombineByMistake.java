package com.dyh.permutationandcombination;

/**
 * 错装信封练习题：有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?
 * 给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。
 * 例：2
 * 返回：1
 * 思路：利用排列组合
 * @author dyh
 *
 */

public class CombineByMistake {

	public static int countWays(int n) {
		// write code here
		if(n == 1){
			return 0;
	    }
		long[] res = new long[n+1];
	    res[2] = 1;
	    for(int i=3;i<=n;i++){
	    	res[i] = (i-1)*(res[i-1] + res[i-2])%1000000007;
	    }
	    return (int)res[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		System.out.println(countWays(n));
	}

}
