package com.dyh.array;

import java.util.Arrays;

/**
 * Squares of a Sorted Array:给一个按照非递减顺序排列的数组，返回每一个元素的平方值，并且也是按照非递减顺序排序
 * 例：[-4,-1,0,3,10]
 * 返回：[0,1,9,16,100]
 * @author dyh
 *
 */

public class SquaresOfASortedArray {

	//原
	public static int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0){
        	return A;
        }
        for(int i = 0; i < A.length; i++){
        	A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
		return A;
    }
	
	//改
	public static int[] sortedSquares2(int[] A){
		if(A == null || A.length == 0){
	      	return A;
	    }
		int first = 0;
		int last = A.length - 1;
		int[] res = new int[A.length];
		for(int i = A.length - 1; i >= 0; i--){
			if(Math.abs(A[first]) < Math.abs(A[last])){
				res[i] = A[last] * A[last];
				last --;
			}else{
				res[i] = A[first] * A[first];
				first ++;
			}
		}
		return res;
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-4, -1, 0, 3, 10};
		System.out.println(Arrays.toString(sortedSquares2(A)));
	}

}
