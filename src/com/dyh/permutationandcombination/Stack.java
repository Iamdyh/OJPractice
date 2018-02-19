package com.dyh.permutationandcombination;

/**
 * 进出栈练习题：n个数进出栈的顺序有多少种？假设栈的容量无限大。
 * 给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。
 * 例：1
 * 返回：1
 * 思路：利用排列组合：通过分析得到： 1/(n-1) * C(2n, n),这个公式是卡特兰数重要公式之一
 * @author dyh
 *
 */
public class Stack {

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
