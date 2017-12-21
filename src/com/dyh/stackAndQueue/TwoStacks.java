package com.dyh.stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

/**
 * 双栈排序练习题:请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 例：[1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 * 思路：新建一个辅助栈temp， 如果栈stack栈顶中的元素小于temp中的栈顶元素，stack出栈压入到temp中，
 *      如果大于的话就将当前的stack栈顶元素出栈记为t，将temp栈顶元素出栈压入到stack，直到temp为空，或者
 *      当前的temp栈顶元素大于等于t，然后将t压入到temp中，并且将其他出栈到stack中的元素继续压入temp中来，
 *      最后将temp中的所有元素压入到stack中，此时求得到stack中到元素顺序即为所求。
 * @author dyh
 *
 */
public class TwoStacks {
	
	public static ArrayList<Integer> twoStacksSort(int[] numbers) {
	        // write code here
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		int current = 0;
		int t = 0;
		int count = 0;
		for(int i = numbers.length-1; i >= 0; i--) {
			stack.push(numbers[i]);
		}
		
		while(!stack.empty()){
			if(temp.empty()) {
				temp.push(stack.pop());
				current = temp.peek();
			}
			if(stack.peek() <= current) {
				temp.push(stack.pop());
				current = temp.peek();
			}else {
				t = stack.pop();
				while(!temp.empty()){
					if(temp.peek() < t) {
						stack.push(temp.pop());
						count++;
					}else
						break;
				}
				temp.push(t);
				while(count > 0) {
					temp.push(stack.pop());
					count--;
				}
				
			}
		}
		while(!temp.empty()) {
			stack.push(temp.pop());
		}
		while(!stack.empty())
			list.add(stack.pop());
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {4,2,1,3,5};
		System.out.println(twoStacksSort(numbers));
	}

}
