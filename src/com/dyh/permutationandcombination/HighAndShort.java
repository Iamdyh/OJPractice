package com.dyh.permutationandcombination;

/**
 * 高矮排列练习题 :12个高矮不同的人，排成两排，每排必须是从矮到高排列，而且第二排比对应的第一排的人高，问排列方式有多少种？
 * 给定一个偶数n，请返回所求的排列方式个数。保证结果在int范围内。
 * 测试样例：1
 * 返回：1
 * 思路：利用排列组合：通过分析得到： 1/(n-1) * C(2n, n),这个公式是卡特兰数重要公式之一
 * @author dyh
 *
 */

public class HighAndShort {
	public static int countWays(int n) {
		// write code here
		int res = 1;
		//此题和之前的括号问题稍有区别，需要将n变成n/2
		for(int i = n/2+1; i <= (n+n)/2; ++i) {
			res *= i;
			
		}
		for(int i = 2; i <= n/2 + 1; ++ i) {
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
