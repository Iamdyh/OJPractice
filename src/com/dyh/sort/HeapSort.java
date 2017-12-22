package com.dyh.sort;

import java.util.Arrays;
/**
 * 堆排序
 * 时间复杂度：平均情况：O(nlog2n),最好情况：O(nlog2n),最坏情况：O(nlog2n);
 * 空间复杂度：辅助存储：O(1)
 * 稳定性：不稳定
 * @author dyh
 *
 */


public class HeapSort {
	
	/**
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public static int[] heapSort(int[] A, int n){
		for(int i = n/2; i >= 0; i--){
			heapAdjust(A, i, n);
		}
		for(int i = n-1; i > 0; i--){
			swap(A, 0, i);
			heapAdjust(A, 0, i);
		}
		return A;
	}
	public static void heapAdjust(int[] A, int index, int length){
		int temp = A[index];
		for(int j = 2 * index+1; j < length; j = 2*j + 1){
			//���������
			if(j < length - 1 && A[j] < A[j + 1]){
				j++;
			}
			if(temp > A[j])
				break;
			A[index] = A[j];
			index = j;
		}
		A[index] = temp;
	}
	public static void swap(int[] A, int m, int n){
		int temp = A[m];
		A[m] = A[n];
		A[n] =temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {8,6,7,1,3,2,5,4};
		System.out.println(Arrays.toString(heapSort(A, 8)));
	}

}
