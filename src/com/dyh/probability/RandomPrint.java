package com.dyh.probability;

import java.util.Random;

/**
 * 随机数组打印练习题: 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
 * 思路：1、在0~n-1中随机得到一个位置a，打印arr[a]，然后arr[a]和数组最后一个位置交换；
 * 2、在0~n-2中随机得到一个位置b，打印arr[b], 然后arr[b]和倒数第二个位置交换；
 * 3、一直重复上述步骤，直到打印够M个数。
 * 注意：很多等概率随机的题都是利用和最后一个数交换的方法
 * @author dyh
 */
public class RandomPrint {
	public static int[] print(int[] arr, int N, int M) {
		Random random = new Random();
		int[] res = new int[M];
		for(int i = 0; i < M; i++) {
			res[i] = arr[random.nextInt(N)%N];
		}
		return res;
		
    }
	
	
}
