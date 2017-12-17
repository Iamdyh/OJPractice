package com.dyh.sort;

import java.util.Arrays;
/**
* 选择排序 
* 时间复杂度：平均情况：O(n2),最好情况：O(n2),最坏情况：O(n2);
* 空间复杂度：辅助存储：O(1)
* 稳定性：不稳定
* @author dyh
*
*/

public class SelectionSort {
	public static int[] selectionSort(int[] A){
		 int min = 0;
	        int t = 0;
	        for(int i = 0; i < A.length; i++){
	            min = i;
	            for(int j = i+1; j < A.length; j++){
	                if(A[j] < A[min]){
	                    min = j; 
	                }
	            }
	            if(min != i){
	                t = A[min];
	                A[min] = A[i];
	                A[i]= t;
	            }
	        }
	        return A;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,2,1,5,4};
		System.out.println(Arrays.toString(selectionSort(a)));
	}

}
