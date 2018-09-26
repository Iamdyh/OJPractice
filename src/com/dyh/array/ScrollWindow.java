package com.dyh.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * 滑动窗口的最大值：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 思路：利用双端队列的特点，保存数组的下标
 * @author dyh
 *
 */

public class ScrollWindow {
	
	public static ArrayList<Integer> maxInWindows(int [] num, int size){
		if(num == null || num.length < 1 || num.length < size)
			return null;
		ArrayList<Integer> res = new ArrayList<>();
		ArrayDeque<Integer> qDeque = new ArrayDeque<>();
		int start = 0;
		for(int i = 0; i < num.length; i++){
			start = i - size + 1;
			if(qDeque.isEmpty()){
				qDeque.add(i);
			}else if(start > qDeque.peekFirst()){
				//peekFirst():此方法检索，但是不移除此deque 队列的第一个元素
				qDeque.pollFirst();
			}
			while((!qDeque.isEmpty()) && num[qDeque.peekLast()] <= num[i]){
				//peekLast():此方法检索，但是不移除此deque队列的最后一个元素
				qDeque.pollLast();
			}
			qDeque.add(i);
			if(start >= 0){
				res.add(num[qDeque.peekFirst()]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2,3,4,2,6,2,5,1};
		int size = 3;
		ArrayList<Integer> arrayList = maxInWindows(num, size);
		for (Integer integer : arrayList) {
			System.out.println(integer);
		}
	}

}
