package com.dyh.array;

/**
 * 数组中重复的数字：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
 * 例：{2,3,1,0,2,5,3}
 * 返回：2
 * @author dyh
 *
 */
public class DuplicateSolution {
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < length; i++){
			sb.append(numbers[i] + "");
			
		}
		for(int i = 0; i < length; i++){
			if(sb.indexOf(numbers[i] + "") != sb.lastIndexOf(numbers[i] + "")){
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,1,0,2,5,3};
		int[] d = new int[1];
		System.out.println(duplicate(a, a.length, d));
	}

}
