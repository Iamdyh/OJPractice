package com.dyh.array;

/**
 * 求1+2+3+...+n:求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 思路：1.需利用逻辑与的短路特性实现递归终止。 
 * 		2.当n==0时，(n>0)&&((sum+=sum(n-1))>0)只执行前面的判断，为false，然后直接返回0；
 *      3.当n>0时，执行sum+=sum(n-1)，实现递归计算sum(n)。
 * @author dyh
 *
 */

public class SumSolution {
	
	public static int sum(int n){
		 int sum = n;
		 boolean res = (n > 0) && ((sum+=sum(n-1)) > 0);
		 return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(sum(n));
	}	

}
