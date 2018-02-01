package com.dyh.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树判断练习题: 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 * 完全二叉树：完全二叉树是指除了最后一层之外，其他每一层的节点数都是满的。最后一层如果也满了，是
 * 一颗满二叉树，也是完全二叉树。最后一层如果不满，缺少的节点也全部的集中在右边，那也是一颗完全二叉树。
 * 思路：1、采用按层遍历二叉树的方式，从每层的左边向右边依次遍历所有的节点。
 *     2、如果当前节点有右孩子，但没有左孩子，直接返回false。
 *     3、如果当前节点并不是左右孩子全有，那之后的节点必须都为叶节点，否则返回false。
 *     4、遍历过程中如果不返回false，遍历结束后返回true即可。
 * @author dyh
 *
 */
public class CheckCompletion {
	
	public static boolean chk(TreeNode root) {
	        // write code here
		Queue<TreeNode> queue = new LinkedList<>();
		boolean flag = true;
		TreeNode cur = null;
		queue.offer(root);
		while(!queue.isEmpty()) {
			cur = queue.poll();
			//如果当前节点有右孩子，但没有左孩子，直接返回false。
			if(cur.right != null && cur.left == null)
				return false;
			else if(cur.left != null && cur.right == null) {
				queue.offer(cur.left);
				flag = false;
				continue;
			}
			if(!flag) {
				if(cur.left != null || cur.right != null) {
					return false;
				}
			}
			if(cur.left != null) {
				queue.offer(cur.left);
			}
			if(cur.right != null) {
				queue.offer(cur.right);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		root.left.left = node3;
		root.left.right = node4;
		root.right.left = node5;
		
		System.out.println(chk(root));

	}

}
