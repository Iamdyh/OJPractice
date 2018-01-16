package com.dyh.binarySearch;

/**
 * 局部最小值位置练习题:定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。 
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 * 思路：利用二分查找的思想，先判断首尾两个元素是不是所求，然后利用二分查找，一次判断，直到找到为止。
 * 
 * @author dyh
 *
 */

public class Solution {

	public static int getLessIndex(int[] arr) {
		//数组不存在时返回-1
		if(arr == null || arr.length == 0)
			return -1; 
		int len = arr.length;
		//如果长度为1或者，arr[0] < arr[1]时，说明arr[0]是局部位置最小的
		if(len == 1 || arr[0] < arr[1]) {
			return 0;
		}
		//如果arr[len-1] < arr[len - 2]说明最后一个数是局部位置最小的
		if(arr[len-1] < arr[len-2])
			return len - 1;
		
		//其他情况说明局部位置最小的数在数组中间，利用二分查找的方式，找到局部最小的数
		int left = 1;
		int right = len - 2;
		int mid = 0;
		while(left < right) {
			mid = (left + right) / 2;

			if(arr[mid] > arr[mid-1]) {
				//说明局部最小的数在arr[mid]的左边
				right = mid - 1;
			}else if(arr[mid] > arr[mid +1]) {
				//说明局部最小的数在arr[mid]的右边
				left = mid + 1;
			}else {
				//说明局部最小的数是arr[mid]
				return mid;
			}
		}
		//left和right相等，说明此时的数即为最小
		return left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,4,3,2,8,7,6,99,55,77,44, 88};
		System.out.println(getLessIndex(arr));
		
	}

}
