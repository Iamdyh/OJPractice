package com.dyh.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 求目标的下标：给定一个数组，一个值target，如果数组中有两个数相加等于target，那么返回两个数的下标，否则返回null。
 * @author dyh
 *
 */

public class TwoSum {
	
	public static int[] sum(int[] arr, int target){
		int[] res = new int[2];
		int flag = -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(target - arr[i])){ 
				res[0] = map.get(target-arr[i]);
				res[1] = i;
				flag = 1;
			}
			map.put(arr[i], i);   //将值和键放进map中， 此时值作为键，键作为值
			
		}
		if(flag == 1){
			return res;
		}else{
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 7, 11, 15};
		int target = 18;
		System.out.println(Arrays.toString(sum(arr, target)));
	}

}
