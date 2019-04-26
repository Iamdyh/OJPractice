package com.dyh.array;

/**
 * Smallest Range I:题目的意思是对一个数组A中的每一个数，都加一个x，x的取值范围是-K <= x <= K，x每次可以不一样，然后得到结果数组B，取B中的最大值和最小值，让这两者的差最小（最小是0），求这个最小值。
 * 例: A=[0, 10], k = 2， B=[2, 8]
 * 返回：6
 * @author dyh
 *
 */

public class SmallestRangeI {
	
	public static int smallestRangeI(int[] A, int K) {
		int res = 0;
		int max = A[0];
		int min = A[0];
		for(int i = 0; i < A.length; i++){
			if(A[i] > max){
				max = A[i];
				
			}
			if(A[i] < min){
				min = A[i];
			}
		}
//		只要A的最大和最小值之差小于2倍K，我们就能让B中的元素全部相等
		if((max - min) < (K * 2)){
			res = 0;
		}else{
			res = (max - min) - (K * 2);
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 3, 6};
		int k = 3;
		System.out.println(smallestRangeI(A, k));
	}

}
