package com.dyh.intelligence;

/**
 * 涂色练习题：你要在一个nxm的格子图上涂色，你每次可以选择一个未涂色的格子涂上你开始选定的那种颜色。同时为了美观，我们要求你涂色的格子不能相邻，也就是说，不能有公共边，现在问你，在采取最优策略的情况下，你最多能涂多少个格子？
 * 给定格子图的长n和宽m。请返回最多能涂的格子数目。
 * 例：1,2
 * 返回：1
 * @author dyh
 *
 */

public class Paint {
	
	public static int getMost(int n, int m){
		int max = 0;
		max = (n * m + 1) / 2;
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int m = 3;
		System.out.println(getMost(n, m));
	}

}
