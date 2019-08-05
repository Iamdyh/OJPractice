package com.dyh.array;

/**
 * Duplicate Zeros: 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * @author dyh
 *
 */

public class DuplicateZeros {
	
	public static void duplicateZeros(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 0) {
        		count++;
        	}
        }
        for(int i = arr.length - 1; i >= 0; i--) {
        	if(arr[i] != 0) {
        		if(i+count < arr.length) {
        			arr[i+count] = arr[i];
        		}
        		if(count != 0) {
        			arr[i] = 0;
        		}
        	}else {
        		count --;
        	}
        }
		return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,2,3,0,4,5,0};
		duplicateZeros(arr);
	}

}
