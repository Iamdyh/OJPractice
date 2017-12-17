package com.dyh.sort;

import java.util.Arrays;

/**
 * 计数排序
 * @author dyh
 *
 */

public class CountingSort {

	public static int[] countingSort(int[] A, int n){
		int min = A[0];
		int max = A[0];
		for(int i = 0; i < n; i++){
			min = Math.min(A[i], min);
			max = Math.max(A[i], max);
		}
		int[] countArr = new int[max - min +1];
		for(int i = 0; i < n; i++){
			countArr[A[i]- min]++;
		}
		int index = 0;
		for(int i = 0; i < countArr.length; i++){
			while(countArr[i]-- > 0){
				A[index++] = i+min;
			}
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,5,2,3};
		System.out.println(Arrays.toString(countingSort(arr, 6)));
	}

}
