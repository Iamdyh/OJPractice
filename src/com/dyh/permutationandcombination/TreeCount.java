package com.dyh.permutationandcombination;

/**
 * 二叉树统计练习题 :求n个无差别的节点构成的二叉树有多少种不同的结构？
 * 给定一个整数n，请返回不同结构的二叉树的个数。保证结果在int范围内。
 * 测试样例：1
 * 返回：1
 * 思路：利用排列组合：通过分析得到： 1/(n+1) * C(2n, n),这个公式也是卡特兰数重要公式之一
 * @author dyh
 *
 */
public class TreeCount {
	public static int countWays(int n) {
		// write code here
		int res = 1;
		for(int i = n+1; i <= n+n; ++i) {
			res *= i;
			
		}
		for(int i = 2; i <= n + 1; ++ i) {
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
