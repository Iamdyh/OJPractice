package com.dyh.permutationandcombination;

/**
 * 分糖果练习题:n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
 * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
 * 例：10，3
 * 返回：36
 * 思路：利用排列组合：n颗糖果有n-1个空隙，分给m个人就需要m-1个挡板隔开，所以为C(n-1, m-1)
 * @author dyh
 *
 */
public class Distribution {

	public static int getWays(int n, int m) {
		// write code here
		--n;
		--m;
		int res = 0;
		int sum = 1;
		int sum1 = 1;
		for(int i = n; i >= (n-m+1); --i) {
			sum = sum * i;        
		}
		for(int i = 1; i <= m; i++) {
			sum1 = sum1 * i;       //m的阶乘
		}
		res = sum / sum1;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int m = 3;
		System.out.println(getWays(n, m));
	}

}
