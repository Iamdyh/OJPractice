package com.dyh.dynamic;

import java.util.Scanner;

/**
 * 求最长公共子序列长度
 * 用动态规划法来求解最长公共子序列，因为最长公共子序列具有最有子结构性质，可以分成子问题来递归求最优解，最后组合子问题求解出问题。用c[i][j]记录X[i]与Y[j]
 * 的LCS 的长度，求解问题c[i,j]，可以分成c[i-1][j-1]、c[i-1][j]、c[i][j-1]子问题来求解，依次递堆到最小子问题，动态规划的递归式描述为：
 * @author dyh
 *
 */
public class LongestCommonSub {

	public static int longestCommonSub(String a, String b){
		int res = 0;
		int[][] dp = new int[a.length()+1][b.length()+1];
		//初始化边界，过滤掉0的情况
		for(int i = 0; i <= a.length(); i++){
			dp[i][0] = 0;
		}
		for(int j = 0; j <= b.length(); j++){
			dp[0][j] = 0;
		}
		//填充矩阵
		for(int i = 1; i <= a.length(); i++){
			for(int j = 1; j <= b.length(); j++){
				//相等情况
				if(a.charAt(i-1) == b.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					//比较“左边”和“上边“，根据其max来填充
					if(dp[i-1][j] >= dp[i][j-1]){
						dp[i][j] = dp[i-1][j];
					}else{
						dp[i][j] = dp[i][j-1];
					}
				}
			}
		}
		res = dp[a.length()][b.length()];
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine().trim();
		String b = scanner.nextLine().trim();
		int res = longestCommonSub(a, b);
		System.out.println(res);
	}

}
