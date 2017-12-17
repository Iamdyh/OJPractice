package com.dyh.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：平均情况：O(n2),最好情况：O(n),最坏情况：O(n2);
 * 空间复杂度：辅助存储：O(1)
 * 稳定性：稳定
 * @author dyh
 *
 */

public class BubbleSort {
	public static void bubbleSort(int[] a){
		for(int i = 0; i < a.length-1; i++){
			for(int j = 0; j < a.length - i - 1; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b = {2,1,0,2,4,6,3};
		bubbleSort(b);
		System.out.println(Arrays.toString(b));
		
	}

}
