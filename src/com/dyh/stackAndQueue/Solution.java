package com.dyh.stackAndQueue;
/**
 * 可查询最值的栈练习题:定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 例：压入：3，4，5，1，2，1
 * 返回：1
 * 思路：方法一：1、新建两个栈stackData和stackMin，一个记录元素，一个记录最小值；
 * 			   2、将第一个元素同时压入两个栈；
 * 			   3、将接下来的每个元素压入stackData，然后分别和stackMin中的栈顶元素比较，如果比栈顶元素小就压入栈顶，否则就跳过；
 * 			   4、当所有元素压入后，stackData中就是所有的数据，stackMin中的栈顶元素就是最小值。
 *      方法二： 1、新建两个栈stackData和stackMin，一个记录元素，一个记录最小值；
 *              2、将第一个元素同时压入两个栈；
 *              3、将接下来的每个元素压入stackData，然后分别和stackMin中的栈顶元素比较，如果比栈顶元素小就压入栈顶，否则stackMin中就压入栈顶元素；
 *              4、当所有元素压入后，stackData中就是所有的数据，stackMin中的栈顶元素就是最小值。
 * 方法比较：方法一：消耗时间，节省空间；方法二：消耗空间，节省时间。
 * @author dyh
 *
 */

import java.util.Stack;

public class Solution {
	private  Stack<Integer> stackData = new Stack<>();
	private  Stack<Integer> stackMin = new Stack<>();
	/**
	 * 方法一
	 * @param node
	 */
    public void push1(int node) {
        stackData.push(node);
        if(stackMin.empty() || stackMin.peek() >= node) {
        		stackMin.push(node);
        }
    }
    
    /**
     * 方法二
     * @param node
     */
    public void push2(int node) {
        stackData.push(node);
        if(stackMin.empty() || stackMin.peek() >= node) {
        		stackMin.push(node);
        }else {
        		stackMin.push(stackMin.peek());
        }
    }
    
    public void pop() {
    		if(stackData.empty()) {
    			throw new RuntimeException("Your stack is empty!");
    		}else if(stackData.peek() == stackMin.peek()) {
    			stackMin.peek();
    		}
        stackData.pop();
    }
    
    public int top() {
        return stackData.peek();
    }
    
    public int min() {
        if(stackMin.empty()) {
        	 	throw new RuntimeException("Your stack is empty!");
        }else {
        		return stackMin.peek();
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,5,1,2,1};
		Solution s = new Solution();
		for(int i = 0; i < 6; i++) {
			s.push1(arr[i]);
		}
		System.out.println(s.min());
	}

}
