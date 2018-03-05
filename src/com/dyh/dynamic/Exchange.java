package com.dyh.dynamic;

/**
 * 找零钱练习题:有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * 例：[1,2,4],3,3
 * 返回：2
 * 思路：利用动态规划的方法
 * @author dyh
 *
 */

public class Exchange {
	
	public static int countWays(int[] penny, int n, int aim) {
        // write code here
		if(penny == null || n == 0 || aim < 0) {
			return 0;
		}
		int[] dp = new int[aim+1];
		dp[0] = 1;
		for(int i = 0 ; i < n; i++) {
			for(int j = penny[i]; j <= aim; j++) {
				dp[j] += dp[j-penny[i]];
			}
		}
		return dp[aim];
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] penny = {1,2,4};
		System.out.println(countWays(penny, 3, 3));

	}

}
