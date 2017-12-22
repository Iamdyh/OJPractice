package com.dyh.stackAndQueue;

import java.util.Stack;

/**
 * 栈的反转练习题:实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * 例：[4,3,2,1],4
 * 返回：[1,2,3,4]
 * 
 * @author dyh
 *
 */

public class StackReverse {
	
	/**
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public static int[] reverseStack(int[] A, int n) {
	        // write code here
		if(n == 0)
			return A;
		int a = get(A, n);
		n--;
		reverseStack(A, n);
		A[n] = a;
		return A;
    }
	
	/**
	 * 移除栈底元素并返回
	 * @param stack
	 * @return
	 */
	public static int get(int[] A, int n) {
		int result = A[n-1];
		n--;
		if(n == 0) {
			return result;
		}else {
			int last = get(A, n);
			A[n-1] = result;
			return last;
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,3,2,1};
		A = reverseStack(A, 4);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
