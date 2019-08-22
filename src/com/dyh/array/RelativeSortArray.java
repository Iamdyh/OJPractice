package com.dyh.array;

import java.util.Arrays;

/**
 * Relative Sort Array:给你两个数组，arr1 和 arr2，arr2 中的元素各不相同,arr2 中的每个元素都出现在 arr1 中
 *    对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * input:arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * output:[2,2,2,1,4,3,3,9,6,7,19]
 * @author dyh
 *
 */
public class RelativeSortArray {
	
	//计数排序
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int[] temp = new int[1001];
		int len2 = arr2.length;
		int count = 0;
		for(int i = 0; i < len1; i++) {
			temp[arr1[i]] ++;
		}
		for(int i = 0; i < len2; i++) {
			int num = arr2[i];
			for(int j = 0; j < temp[num]; j++) {
				arr1[count ++] = num;
			}
			temp[num] = 0;
		}
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] != 0) {
				for(int j = 0; j < temp[i]; j++) {
					arr1[count ++] = i;
				}
			}
		}
		return arr1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
	}

}
