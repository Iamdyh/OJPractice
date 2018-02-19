package com.dyh.permutationandcombination;

/**
 * 排队买票练习题 :2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。
 * 给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。
 * 测试样例：1
 * 返回: 1
 * 思路：利用排列组合：通过分析得到： 1/(n-1) * C(2n, n),这个公式是卡特兰数重要公式之一
 * @author dyh
 *
 */

public class BuyTickets {
	
	public static int countWays(int n) {
        // write code here
	int res = 1;
	for(int i = n+1; i <= n+n; ++i) {
		res *= i;     
	}
	for(int i = 2; i<= n+1; ++i) {
		res /= i;
	}
	return res;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(countWays(n));
	}

}
