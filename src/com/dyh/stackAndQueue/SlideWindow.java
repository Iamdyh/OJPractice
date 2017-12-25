package com.dyh.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 滑动窗口练习题:有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。 
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。
 * 因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。
 * 第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 * 例：[4,3,5,4,3,3,6,7],8,3
 * 返回：[5,5,5,4,6,7]
 * 思路：利用双端队列，双端队列qmax={},双端队列存放着数组中的下标值。
 *      假设当前数为arr[i], 放入规则如下：
 *      1、如果qmax为空，直接把下标i放入qmax中。
 *      2、如果qmax不为空，取出当前qmax队尾存放的下标j。如果arr[j] > arr[i],直接把
 *      下标i放进qmax的队尾。
 *      3、如果arr[j] <= arr[i], 则一直从qmax的队尾弹出下标，直到某个下标在qmax中
 *      对应的值大于arr[i], 把i放入qmax的队尾。
 *      弹出规则如下：
 *      如果qmax队头的下标等于i-w，弹出qmax当前队头下标。
 *    
 * @author dyh
 *
 */

public class SlideWindow {
	
	/**
	 * 常规解法，时间复杂度为O(N*w)
	 * 每次对w个数进行遍历，选出其最大值
	 * @param arr
	 * @param n
	 * @param w
	 * @return
	 */
	public static int[] slide1(int[] arr, int n, int w) {
		int[] res = new int[n-w+1];
		int count = 0;
		int max = 0;
		for(int i = 0; i < n-w+1; i++) {
			for(int j = i; j < w+i; j++) {
				if(arr[j] > max) {
					max = arr[j];
				}
			}
			res[count++] = max;
			max = 0;
		}
		return res;
	}
	
	/**
	 * 优化解法，利用双端队列Deque，时间复杂度为O(N)
	 * @param arr
	 * @param n
	 * @param w
	 * @return
	 */
	public static int[] slide2(int[] arr, int n, int w) {
		if(arr == null || w < 1 || n < w)
			return null;
		int[] res = new int[n-w+1];
		Deque<Integer> qmax = new LinkedList<>();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			//删除队尾元素
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			//队头元素等于i-w，删除队头元素
			if(qmax.peekFirst() ==  i - w) {
				qmax.pollFirst();
			}
			//因为下标是从0开始的，所以取值时下标最小也只能取w-1；
			if( i >= w-1) {
				res[count++] = arr[qmax.peekFirst()];
			}
			
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,5,4,3,3,6,7};
		int[] res = new int[6];
		//res = slide1(arr, 8, 3);
		res = slide2(arr, 8, 3);
		for(int i = 0; i < 6; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
