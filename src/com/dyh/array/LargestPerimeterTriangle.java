package com.dyh.array;

import java.util.Arrays;

/**
 * Largest Perimeter Triangle:Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 * If it is impossible to form any triangle of non-zero area, return 0.
 * input:[2,1,2]
 * output:5
 * @author dyh
 *
 */
public class LargestPerimeterTriangle {
	
	//从大到小排个序，从大到小每次取3个数进行判断（如果这三个数都不能形成三角形，那么加入更小的数就更形不成三角形）
	public static int largestPerimeter(int[] A) {
		int len = A.length;
		Arrays.sort(A);
		for(int i = len - 1; i >=2; i--) {
			if(A[i] < A[i-1] + A[i-2]) {
				return A[i] + A[i-1] + A[i-2];
			}
		}
		
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 6, 2, 3};
		System.out.println(largestPerimeter(A));
	}

}
