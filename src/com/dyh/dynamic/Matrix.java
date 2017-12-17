package com.dyh.dynamic;
/**
 * 问题描述：给定n个矩阵：A1,A2,...,An，其中Ai与Ai+1是可乘的，i=1，2...，n-1。
 * 确定计算矩阵连乘积的计算次序，使得依此次序计算矩阵连乘积需要的数乘次数最少。
 * 输入数据为矩阵个数和每个矩阵规模，输出结果为计算矩阵连乘积的计算次序和最少数乘次数。
 * @author dyh
 *
 */
public class Matrix {
	
	//计算最优值
	public static void matrixChain(int[] p, int[][] m, int[][] s){
		int n = p.length - 1;
		for(int i = 1; i <= n; i++){
			m[i][i] = 0;              //矩阵段长度为1,则m[][]中对角线的值为0,表示只有一个矩阵,没有相乘的.
		}
		for(int r = 2; r<= n; r++){//r表示矩阵的长度(2,3…逐渐变长)
			for(int i = 1; i <= n-r+1; i++){
				//从第i个矩阵Ai开始,长度为r,则矩阵段为(Ai~Aj)
				int j = i+r-1;             //当前矩阵段(Ai~Aj)的起始为Ai,尾为Aj
				m[i][j] = 999999999;
				s[i][j] = i;
				for(int k = i; k < j; k++){
					int t = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(t < m[i][j]){
						m[i][j] = t;
						s[i][j] = k;
					}
				}
				
			}
		}
	}

	//构造最优解
	public static void traceBack(int[][] s, int i, int j){
		if(i != j){
			traceBack(s, i, s[i][j]);
			traceBack(s, s[i][j]+1, j);
			System.out.println("Multiply A["+i+":" + s[i][j]+"] and A["+(s[i][j]+1)+":"+j+"]");
		}
	}
	//打印加括号的最优解方案
	public static void OptimalParens(int[][] s, int i, int j){
		if(i == j)
			System.out.print("(A"+i);
		else{
			OptimalParens(s, i, s[i][j]);
			OptimalParens(s, s[i][j]+1, j);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {30,35,15,5,10,80,25,65,40,20};
		int n = p.length;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		matrixChain(p, m, s);
		System.out.println("该矩阵阶乘子问题数乘的次数:");
		for(int i = 1; i < m.length; i++){
			for(int j = 1; j < m.length; j++){
				if(i>j){
					System.out.print("---------"+"\t");
				}else{
					System.out.print(m[i][j]+"\t");
				}
			}
			System.out.println();
		}
		System.out.println();
		 System.out.println("该矩阵阶乘子问题数乘的次数:");
	        for(int i=1;i<s.length;i++){
	            for(int j=1;j<s.length;j++){
	                if(i>j)
	                    {
	                       System.out.print("----"+"\t");
	                    }
	                else
	                    {
	                       System.out.print(s[i][j]+"\t");
	                    }
	            }
	            System.out.println();
	        }
	        System.out.println();
	        System.out.println("该矩阵阶乘的最优解:");
	        traceBack(s,1,n-1);
	        OptimalParens(s,1,n-1);
	}

}
