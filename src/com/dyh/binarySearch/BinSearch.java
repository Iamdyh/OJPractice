package com.dyh.binarySearch;

/**
 * 二分查找
 * @author dyh
 *
 */

public class BinSearch {

	public static int binSearch(int[] arr, int k){
		int left = 0;
		int right = arr.length-1;
		while(left <= right){
			int mid = left + (right-left)/2; //(left+right)/2有整数溢出风险，因为int是4字节，有一定范围。如果两个其中一个很大，相加容易超出这个范围，改成相减的形式可以一定程度避免。
			if(k > arr[mid])
				left = mid+1;
			else if(k < arr[mid])
				right = mid - 1;
			else {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,8,9};
		int k = 10;
		int index = binSearch(arr, k);
		System.out.println(index);
	}

}
