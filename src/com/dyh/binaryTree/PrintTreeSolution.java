package com.dyh.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 按之字顺序打印二叉树：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路：如果是奇数层，就将结点按照从右到左的顺序入栈，如果是偶数层，就按从左到右的顺序入栈。
 * @author dyh
 * 
 */
public class PrintTreeSolution {
	
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		int flag = 1;
		if(pRoot == null){
			return arrayLists;
		}
		
		stack1.push(pRoot);
		while(!stack1.empty() || !stack2.empty()){
			if(flag % 2 != 0){
				ArrayList<Integer> arrays = new ArrayList<>();
				while(!stack1.empty()){
					TreeNode pNode = stack1.pop();
					if(pNode != null){
						arrays.add(pNode.val);
						stack2.push(pNode.left);
						stack2.push(pNode.right);
					}
				}
				if(!arrays.isEmpty()){
					arrayLists.add(arrays);
					flag++;
				}
			}else{
				ArrayList<Integer> temp = new ArrayList<>();
				while(!stack2.empty()){
					TreeNode pNode = stack2.pop();
					if(pNode != null){
						temp.add(pNode.val);
						stack1.push(pNode.right);
						stack1.push(pNode.left);
					}
					
				}
				if(!temp.isEmpty()){
					arrayLists.add(temp);
					flag++;
				}
			}
		}
		
		return arrayLists;
		
 	}
}
