package com.dyh.dynamic;

/**
 * 最优编辑练习题：对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 例："abc",3,"adc",3,5,3,100
 * 返回：8
 * @author dyh
 *
 */
public class MinCost {

	public static int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
	        // write code here
		char[] str1 = A.toCharArray();
		char[] str2 = B.toCharArray();
		int[][] dp = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			dp[i][0] = c1 * i;       //给第一行赋值
		}
		for(int j = 1; j <= m; j++) {
			dp[0][j] = c0 * j;       //给第一列赋值
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(str1[i-1] != str2[j-1]) {
					dp[i][j] = Math.min(Math.min(c1+dp[i-1][j], dp[i][j-1]+ c0), dp[i-1][j-1]+ c2);//三个参数分别表示删除，添加和替换
				}else {
					//如果相等就不需要替换操作
					dp[i][j] = Math.min(Math.min(c1+dp[i-1][j], dp[i][j-1]+ c0), dp[i-1][j-1]); 
				}
			}
			
		}
		return dp[n][m];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "abc";
		String B = "adc";
		System.out.println(findMinCost(A, 3, B, 3, 5, 3, 100));
	}

}
