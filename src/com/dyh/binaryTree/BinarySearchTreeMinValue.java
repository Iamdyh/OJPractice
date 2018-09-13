package com.dyh.binaryTree;
/**
 * 二叉搜索树的第k个结点：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 思路：根据二叉搜索树的特点，利用中序遍历，即可找到所求的结点
 * @author dyh
 *
 */

public class BinarySearchTreeMinValue {
	int count = 0;
	TreeNode kthNode(TreeNode pRoot, int k){
		if(pRoot == null || k == 0)
			return null;
		count = k;
		return inOrder(pRoot);
	}
	
	TreeNode inOrder(TreeNode pNode){
		
		TreeNode temp = null;
		if(temp == null && pNode.left != null){
			temp = inOrder(pNode.left);
		}
		if(temp == null && count == 1){
			temp = pNode;
		}else{
			count --;
		}
		if(temp == null && pNode.right != null){
			temp = inOrder(pNode.right);
		}
		
		return temp;
	}
}
