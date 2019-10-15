package com.dyh.binaryTree;

import java.util.List;

/**
 *  Univalued Binary Tree:如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *  input:[1,1,1,1,1,null,1]
 *  output:true;
 * @author dyh
 *
 */

public class UnivaluedBinaryTree {

	boolean res = true;
	public boolean isUnivalTree(TreeNode root) {
		if(root != null) {
			if(root.left != null && root.val  != root.left.val || root.right != null && root.val != root.right.val) {
				res = false;
			}
			isUnivalTree(root.left);
			isUnivalTree(root.right);
		}
		return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(2);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(2);
		
		node.left = node1;
		node.right = node2;
		node.left.right = node3;
		node.right.left = node4;
		UnivaluedBinaryTree tree = new UnivaluedBinaryTree();
		System.out.println(tree.isUnivalTree(node));
	}

}
