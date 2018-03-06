package com.dyh.dynamic;

/**
 * 台阶问题练习题：有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 例：1
 * 返回：1
 * 思路：利用动态规划
 * @author dyh
 *
 */

public class GoUpstairs {
	
	public static int countWays(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;   
		dp[1] = 1;  
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(countWays(10));
	}

}
