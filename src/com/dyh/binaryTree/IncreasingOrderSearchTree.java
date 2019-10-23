package com.dyh.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Increasing Order Search Tree:给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * input:[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * output:[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * @author dyh
 *
 */
public class IncreasingOrderSearchTree {
	
	//中序遍历 + 构造新的树
	public TreeNode increasingBST(TreeNode root) {
		List<Integer> array = new ArrayList<Integer>();
		inOrder(root, array);
		TreeNode node = new TreeNode(0);
		TreeNode temp = node;
		for(int v : array) {
			temp.right = new TreeNode(v);
			temp = temp.right;
		}
		return node.right;
    }
	
	public void inOrder(TreeNode node, List<Integer> list) {
		if(node == null) {
			return;
		}
		inOrder(node.left, list);
		list.add(node.val);
		inOrder(node.right, list);
	}

}
