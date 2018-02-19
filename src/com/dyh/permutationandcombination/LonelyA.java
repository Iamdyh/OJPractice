package com.dyh.permutationandcombination;

/**
 * 孤傲的A练习题:A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。
 * 现在问你满足A的要求的对列有多少种？
 * 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
 * 例：6,1,2,3
 * 返回：288
 * 思路：利用排列组合
 * @author dyh
 *
 */
public class LonelyA {

	public static int getWays(int n, int a, int b, int c) {
	        // write code here
		int res = 0;
		//n个人全排列总数
		int sumN = fac(n);
		//a和b作为一个人的总数，因为可以是ab，也可以是ba，所以总数乘2
		int sumab = fac(n-1) * 2;
		//ac作为一个人的总数
		int sumac = fac(n-1)*2;
		//ab和ac共有的部分: bac作为一个人，cab作为一个人
		int sum = fac(n-2)*2;
		
		res = sumN - sumab - sumac + sum;
		return res;
	}
	public static int fac(int s) {
		int res = s;
		for(int i = s-1; i > 0; i--) {
			res = res * i;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int a = 1,b=2,c = 3;
		System.out.println(getWays(n, a, b, c));
	}

}
