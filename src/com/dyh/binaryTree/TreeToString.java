package com.dyh.binaryTree;

/**
 * 二叉树的序列化练习题:首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为str，初始时str等于空字符串。
 * 先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，“#”表示这个节点为空，节点值不存在，
 * 当然你也可以用其他的特殊字符，“!”表示一个值的结束。如果遇到不为空的节点，假设节点值为3，
 * 就在str的末尾加上“3!”。现在请你实现树的先序序列化。
 * 给定树的根结点root，请返回二叉树序列化后的字符串。
 * @author dyh
 *
 */

public class TreeToString {

	 public String toString(TreeNode root) {
	        // write code here
		 if(root == null)
			 return null;
		 StringBuilder sb = new StringBuilder();
		 preOrder(root, sb);
		 return sb.toString();
 	 }
	 
	 public void preOrder(TreeNode node, StringBuilder sb) {
		 if(node == null) {
			 sb.append("#!");
			 return;
		 }
		 sb.append(node.val).append("!");
		 preOrder(node.left, sb);
		 preOrder(node.right, sb);
	 }

}
