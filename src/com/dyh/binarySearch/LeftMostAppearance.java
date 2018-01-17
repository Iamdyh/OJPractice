package com.dyh.binarySearch;
/**
 * 元素最左出现练习题:对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * 例：[1,2,3,3,4],5,3
 * 返回：2
 * 思路:利用二分搜索，先判断中间的数是否等于num，等于的话，arr[mid]右边的数都大于或等于num，所以继续往左边
 * 比较，直到最后只剩下最后一个数时，此时即为所求。
 * @author dyh
 *
 */
public class LeftMostAppearance {
	
	public static int findPos(int[] arr, int n, int num) {
        // write code here
		int res = -1;
		if(arr == null || n == 0)
			return res;
		int left = 0;
		int right = n-1;
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			if(arr[mid] < num) {
				left = mid + 1;
			}else if(arr[mid] > num) {
				right = mid - 1;
			}else {
				res = mid;
				right = mid - 1;
			}
		}
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,3,4};
		System.out.println(findPos(arr, 5, 3));
	}

}
