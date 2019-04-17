package com.dyh.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 按奇偶校验排序数组：给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。你可以返回满足此条件的任何数组作为答案。
 * 例：[3,1,2,4]
 * 返回:[2,4,3,1]或者[4,2,3,1],[2,4,1,3],[4,3,1,3]
 * @author dyh
 *
 */
public class SortArrayByParity {

	//原
	public static int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int count = 0;
        ArrayList<Integer> oddNum = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
        	if(A[i] % 2 == 0){
        		res[count ++] = A[i];
        	}else{
        		oddNum.add(A[i]);
        	}
        	
        }
        for(int i = count, j = 0; i < A.length; i++, j++){
        	res[i] = oddNum.get(j);
        }
        return res;
    }
	
	//改
	public static int[] sortArrayByParity2(int[] A) {
        int lastIndex = A.length;
        int firstIndex = 0;
        int[] res = new int[lastIndex];
        lastIndex--;                                 //因为数组最后一个坐标需要减一
        for(int i = 0; i < A.length; i++){
        	if(A[i] % 2 == 0){                       //偶数放在前面
        		res[firstIndex] = A[i];
        		firstIndex++;
        	}else{
        		res[lastIndex] = A[i];               //奇数放在后面
        		lastIndex--;
        	} 
        }
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0, 1};
		System.out.println(Arrays.toString(sortArrayByParity2(A)));
	}

}
