package com.dyh.array;


import java.util.Arrays;

/**
 * 构建乘积数组：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author dyh
 *
 */
public class MultiplySolution {

	public static int[] multiply(int[] A) {
		int len = A.length;
		int[]  b = new int[len];
		if(len != 0){
			b[0] = 1;
			//计算下三角连乘
			for(int i = 1; i < len; i++){
				b[i] = b[i-1] * A[i-1];
			}
			int temp = 1;
			//计算上三角
			for(int j = len-2; j >= 0; j--){
				temp *= A[j+1];
				b[j] *= temp;
			}
		}
		return b;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 2, 3, 4};
		System.out.println(Arrays.toString(multiply(A)));
	}

}
