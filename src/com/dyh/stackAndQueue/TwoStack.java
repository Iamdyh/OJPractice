package com.dyh.stackAndQueue;

import java.util.Stack;

/**
 * 双栈队列练习题:编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * 例：[1,2,3,0,4,0],6
 * 返回：[1,2]
 * 思路：1、将所有数据压入栈1，这是队列的push操作；
 *      2、将栈1数据全部弹出压入栈2；
 *      3、将数据从栈2弹出，这是队列的pop操作。
 * @author dyh
 *
 */

public class TwoStack {
	
	public static int[] twoStack(int[] ope, int n) {
        // write code here
		
		  Stack<Integer> stackPush = new Stack<>();
			Stack<Integer> stackPop = new Stack<>();
	        int count = 0;
			for(int i = 0; i < n; i++) {
				if(ope[i] != 0) {
					stackPush.push(ope[i]);
				}else {
					//记录0的个数
					count++;
				}
			}
			int[] arr = new int[count];
	        while(!stackPush.isEmpty()){
	            stackPop.push(stackPush.pop());
	        }
			for(int i = 0; i < count; i++) {
				arr[i] = stackPop.pop();
			}
			return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {251,399,0,428,21,0};
		int[] res = twoStack(arr, 6);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
