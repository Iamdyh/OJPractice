package com.dyh.array;

/**
 * 数组中只出现一次的数字：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路：使用异或运算：任何一个数字异或它自己都等于0
 * @author dyh
 *
 */

public class Solution {

	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2){
		if(array == null || array.length < 2)
			return;
		int temp = 0;
		int flag = 1;
		//将数组异或一遍
		for(int i = 0; i < array.length; i++){
			temp ^= array[i];
		}
		//将大数组分成两个小数组
		while((temp & flag) == 0)

			flag <<= 1;
		//在两个小数组中分别找到唯一出现一次的数字
		for(int i = 0; i < array.length; ++ i){
			if((flag & array[i]) == 0)
				num1[0] ^= array[i];
			else
				num2[0] ^= array[i];
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array ={2,4,3,6,3,2,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[2];
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] +" " + num2[0]);
	}

}
