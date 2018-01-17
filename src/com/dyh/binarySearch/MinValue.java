package com.dyh.binarySearch;
/**
 * 循环有序数组最小值练习题:对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 * 例：[4,1,2,3,3], 5
 * 返回：1
 * 思路:利用二分查找，具体见下面注释
 * @author dyh
 *
 */

public class MinValue {
	
	public static int getMin(int[] arr, int n) {
        // write code here
		
		if(arr == null || n == 0)
		   return -1;
		
		int left = 0;
		int right = n-1;
		int mid = 0;
		while(left < right) {
			//当数组只有两个值时
			if(left == right - 1) {
				break;
			}
			//当左边小于右边时，left到right是有序的，最小值即为最左边的数
			if(arr[left] < arr[right]) {
				return arr[left];
			}
			mid = (left + right) / 2;
			//说明最小值在left和mid之间
			if(arr[left] > arr[mid]) {
				right = mid;
				continue;
			}
			//说明最小值在mid和right之间
			if(arr[mid] > arr[right]) {
				left = mid;
				continue;
			}
			//当出现等值的情况
			while(left < mid) {
				if(arr[left] == arr[mid]) {
					left++;
				}else if(arr[left] < arr[mid]) {
					return arr[left];
				}else {
					right = mid;
					break;
				}
			}
		}
		return Math.min(arr[left], arr[right]);
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,2,2,2,2,2,2,1,2};
		System.out.println(getMin(arr, 9));
	}

}
