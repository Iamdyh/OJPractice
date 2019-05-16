package com.dyh.array;
/**
 * Peak Index in a Mountain Array:Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 例：[0,1,0]
 * 返回：1
 * @author dyh
 *
 */
public class PeakIndexInAMountainArray {
	
	public static int peakIndexInMountainArray(int[] A) {
		
		for(int i = 1; i < A.length; i++) {
			if(A[i] > A[i-1]) {
				continue;
			}else {
				return i-1;
			}
			
		}
		
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0, 1, 0};
		System.out.println(peakIndexInMountainArray(A));
	}

}
