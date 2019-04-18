package com.dyh.array;

import java.util.HashMap;
import java.util.Map;

/**
 * n个重复元素的大小是2n：在大小为2N的数组a中，有N+1个惟一元素，其中一个元素恰好重复N次。返回重复N次的元素。
 * 例：[1,2,3,3]
 * 返回：3
 * @author dyh
 *
 */

public class NRepeatedElementInSize2NArray {
	
	//原
	public static int repeatedNTimes(int[] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++){
        	for(int j = i+ 1; j < A.length; j++){
        		if(A[i] == A[j]){                         //只要有相同的，就是重复的元素
        			return A[i];
        		}
        	}
        }
        
        return res;
    }
	
	//改
	public static int repeatedNTimes2(int[] A){
		Map<Integer, Integer> arrays = new HashMap<>();
		for(int i = 0; i < A.length; i++){
			arrays.put(A[i], arrays.getOrDefault(A[i], 0) + 1);
		}
		for(int key: arrays.keySet()){                           //将Map中所有的键存入到set集合中
			if(arrays.get(key) > 1){
				return key;
			}
		}
		throw null;
	}
	
	//改
	public static int repeatedNTimes3(int[] A){
		boolean[] res = new boolean[10000];
		for(int i = 0; i < A.length; i++){
			if(res[A[i]] == true){                             //如果是重复的元素，那么之前一定被置为true
				return A[i];
			}else{
				res[A[i]] = true;
			}
		}
		return -1;
	}
	
	//改
	public static int repeatedNTimes4(int[] A){
		if(A[0] == A[A.length - 1]){
			return A[0];
		}
		//一次循环做两次比较
		for(int i = 0; i < A.length - 1; i++){
			if(i < A.length - 2 && A[i] == A[i + 2]){
				return A[i];
			}
			if(A[i] == A[i + 1]){
				return A[i];
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 3, 3};
		System.out.println(repeatedNTimes4(A));
	}

}
