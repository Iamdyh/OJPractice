package com.dyh.permutationandcombination;

/**
 * 方格移动练习题:在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
 * 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
 * 例：2，2
 * 返回：2
 * 思路：利用排列组合：C(n,m) = n*(n-1)*...*(n-m+1)/(1*2*...*m) 
 * @author dyh
 *
 */

public class Robot {
	
	public static int countWays(int x, int y) {
        // write code here
		int res = 0;
		//剩余格子横竖的总数
		int sum = (x-1) + (y-1);
		int n = 1;
		int m = 1;
		for(int i = sum; i > (y-1); -- i) {
			n = n * i;       //除数
		}
		for(int i = 1; i <= (x-1); i++) {
			m *= i;          //被除数
		}
		res = n/m;
		return res;
		
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2;
		int y = 2;
		System.out.println(countWays(x, y));
	}

}
