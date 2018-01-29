package com.dyh.binaryTree;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树的打印练习题：有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。
 * 保证结点数小于等于500。
 * @author dyh
 *
 */
public class TreePrinter {
	public int[][] printTree(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		//把头结点先放入队列中
		queue.offer(root);
		TreeNode node = null;
		TreeNode last = root;
		TreeNode nLast = last;
		
		if(root == null) {
			return null;
		}
		while(!queue.isEmpty()) {
			node = queue.poll();
			temp.add(node.val);
			if(node.left != null) {
				queue.offer(node.left);
				nLast = node.left;
			}
			if(node.right != null) {
				queue.offer(node.right);
				nLast = node.right;
			}
			if(node == last) {
				res.add(temp);
				temp = new ArrayList<>();
				last = nLast;
			}
		}
		int[][] result = new int[res.size()][];
		for(int i = 0; i < res.size(); i++) {
			result[i] = new int[res.get(i).size()];
			for(int j = 0; j < result[i].length; j++) {
				result[i][j] = res.get(i).get(j);
			}
		}
		return result;
	}
	

}
