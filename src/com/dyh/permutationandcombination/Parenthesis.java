package com.dyh.permutationandcombination;

/**
 * 括号序列练习题:假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。
 * 给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
 * 例：1
 * 返回： 1
 * 思路：利用排列组合，通过分析得到： 1/(n-1) * C(2n, n),这个公式是卡特兰数重要公式之一
 * @author dyh
 *
 */
public class Parenthesis {
	
	public static int countLegalWays(int n) {
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
		System.out.println(countLegalWays(n));
	}

}
