package com.dyh.dynamic;

/**
 *  LIS练习题：这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 *  给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 *  例：[1,4,2,5,3],5
 *  返回：3
 *  思路：利用动态规划
 *  
 * @author dyh
 *
 */

public class LongestIncreasingSubsequence {

	public static int getLIS(int[] A, int n) {
		int[] dp = new int[n];
		dp[0] = 1; //dp[i]表示在必须以arr[i]这个数结尾的情况下，arr[0...i]中的最大递增子序列长度，dp[0]=1表示arr[0]只有一个字符
		int res = 0;
		for(int i = 1; i < n; i++) {
			res = 0;
			for(int j = i-1; j >= 0; j--) {
				if(A[i] > A[j] && dp[j] > res) {
					res = dp[j];
				}
				dp[i] = res + 1;
			}
			
		}
		
		res = 0;
		for(int i = 0; i < n; i++) {
			if(res < dp[i])
				res = dp[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 4, 2, 5, 3};
		System.out.println(getLIS(A, 5));
	}

}
