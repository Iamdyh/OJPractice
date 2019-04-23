package com.dyh.array;

import java.util.Arrays;

/**
 * Sort Array By Parity II:Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * 例：[4, 2, 5, 7]
 * 返回：[4, 5, 2, 7] or [4, 7, 2, 5] or [2, 5, 4, 7] or [2, 7, 4, 5]
 * @author dyh
 *
 */
public class SortArrayByParityII {
	
	public static int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length == 0){
        	return A;
        }
        int len = A.length;
        int[] res = new int[len];
        int evenIndex = 0;
        int oddIndex = 1;
        
        for(int i = 0; i < len; i++){
        	if(A[i] % 2 == 0){
        		res[evenIndex] = A[i];
        		evenIndex += 2;
        	}else{
        		res[oddIndex] = A[i];
        		oddIndex += 2;
        	}
        }
        return res;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4, 2, 5, 7};
		System.out.println(Arrays.toString(sortArrayByParityII(A)));
	}

}
