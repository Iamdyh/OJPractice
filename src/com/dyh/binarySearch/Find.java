package com.dyh.binarySearch;

/**
 * 最左原位: 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 * 例：[-1,0,2,3],4
 * 返回：2
 * 思路：利用二分查找，先判断首尾两个元素是否符合要求，不符合则往中间找
 * @author dyh
 *
 */

public class Find {
	
	public static int findPos(int[] arr, int n) {
        // write code here
		int res = -1;
		if(arr == null || n == 0)
			return res;
		
		int left = 0;
		int right = n-1;
		int mid = 0;
		while(left <= right) {
			//因为是有序数组，所以一般是递增的
			if(arr[left] > left || arr[right] < right) {
				break;
			}
			mid = (left + right) / 2;
			
			if(arr[mid] > mid) {  //大于说明，所求值在左边
				right = mid - 1;
			}else if(arr[mid] < mid) { //小于说明，所求值在右边
				left = mid + 1;
			}else {
				res = mid;       //等于，先记录下来，然后最左的值必然在左边
				right = mid - 1;
			}
		}
		return res;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1, 0, 2, 3};
		System.out.println(findPos(arr, 4));
	}

}
