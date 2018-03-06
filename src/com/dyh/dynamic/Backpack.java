package com.dyh.dynamic;

/**
 * 01背包练习题：一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * 测试样例：[1,2,3],[1,2,3],3,6
 * 返回：6
 * 思路：利用动态规划
 * @author dyh
 *
 */

public class Backpack {

	public static int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
		int[] dp = new int[cap + 1];
		for(int i = 0; i < n; i++) {
			for(int j = cap; j >= w[i]; j--) {
				//dp[j]表示不选第i件物品时的价值，dp[j-w[i]] + v[i]表示选第i件物品时的价值
				dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
			}
		}
		return dp[cap];
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {1,2,3};
		int[] v = {1,2,3};
		int n = 3;
		int cap = 6;
		System.out.println(maxValue(w, v, n, cap));
	}

}
