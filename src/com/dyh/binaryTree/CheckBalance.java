package com.dyh.binaryTree;

/**
 * 平衡二叉树判断练习题：有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 * 二叉树子树：在二叉树中以任何一个节点为头部的整棵树称作二叉树d子树。
 * 平衡二叉树（AVL树）：1、空树是平衡二叉树
 *                2、如果一颗树不为空，并且其中所有的子树都满足各自的左子树
 *                与右子树的高度差都不超过1。
 * 思路：利用递归，用l、r记录左右子树两边的深度
 * @author dyh
 *
 */

public class CheckBalance {
	
	public static boolean check(TreeNode root) {
	        // write code here
		return chk(root) >= 0;
	}
	
	public static int chk(TreeNode root) {
		if(root == null)
			return 0;         //空树是平衡二叉树
		int l = chk(root.left); //左边深度
		int r = chk(root.right); //右边深度
		if(l < 0 || r < 0)
			return -1;
		if((Math.abs(r-l)) > 1)
			return -1;     //当左右两边深度差超过1时，说明不是平衡二叉树，返回-1
		return r > l ? r + 1: l + 1; //说明是平衡二叉树，返回两者中较大的数作为整颗二叉树的深度
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
		
		System.out.println(check(root));

	}

}
