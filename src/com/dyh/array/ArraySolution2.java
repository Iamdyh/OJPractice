package com.dyh.array;

import java.util.ArrayList;

/**
 * 和为S的两个数字:输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * @author dyh
 *
 */

public class ArraySolution2 {
	
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> arrayList = new ArrayList<>();
        if(array == null || array.length < 2)
        	return arrayList;
        int len = array.length;
        int i = 0, j = len-1;
        int curSum = array[0] + array[len-1];
        
        while(i < j){
        	if(curSum == sum){
        		//递增数组，元素相隔越大，则他们的乘积越小，所以只要从数组头尾开始遍历，那么找到后就符合题意
        		arrayList.add(array[i]);
        		arrayList.add(array[j]);
        		break;
        	}else if(curSum > sum){
        		j--;
        	}else{
        		i++;
        	}
        	curSum = array[i] + array[j]; 
        }
        return arrayList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,9};
		System.out.println(FindNumbersWithSum(array, 6));
	}

}
