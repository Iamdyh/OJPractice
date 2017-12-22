package com.dyh.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 直接插入排序
 * 时间复杂度：平均情况：O(n2),最好情况：O(n),最坏情况：O(n2);
 * 空间复杂度：辅助存储：O(1)
 * 稳定性：稳定
 * @author dyh
 * 
 */
public class InsertSort {
	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] insertSort(int[] arr){
		int index = 0;
		for(int i = 1; i < arr.length; i++){
			index = i;
			for(int j = i-1; j >= 0; j--){
				if(arr[j] > arr[index]){
					int t = arr[j];
					arr[j] = arr[index];
					arr[index] = t;
					index = j;
				}
			}
		}
		
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,3,1,4,5,4};
		System.out.println(Arrays.toString(insertSort(array)));
	}

}
