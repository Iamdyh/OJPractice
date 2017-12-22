package com.dyh.sort;

import java.util.Arrays;
/**
 * 归并排序
 * 时间复杂度：平均情况：O(nlog2n),最好情况：O(nlog2n),最坏情况：O(nlog2n);
 * 空间复杂度：辅助存储：O(n)
 * 稳定性：稳定
 * @author dyh
 *
 */

public class MergeSort {
	
	/**
	 * 
	 * @param arr
	 */
	public static void mergeSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		process(arr, 0, arr.length - 1);
	}
	
	public static void process(int[] arr, int left, int right){
		if(left == right){
			return;
		}
		int mid = (left + right)/2;
		process(arr, left, mid);
		process(arr, mid+1, right);
		merge(arr, left, mid, right);
	}
	public static void merge(int[] arr, int left, int mid, int right){
		int[] help = new int[right - left + 1];
		int l = left;
		int r = mid + 1;
		int index = 0;
		while(l <= mid && r <= right){
			if(arr[l] <= arr[r]){
				help[index++] = arr[l++];
			}else{
				help[index++] = arr[r++];
			}
		}
		while(l <= mid){
			help[index++] = arr[l++];
		}
		while(r <= right){
			help[index++] = arr[r++];
		}
		for(int i = 0; i < help.length; i++){
			arr[left + i] = help[i];
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {23,1,4,2,0,435,24,3,4};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}

}
