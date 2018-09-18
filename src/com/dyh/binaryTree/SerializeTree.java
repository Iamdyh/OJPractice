package com.dyh.binaryTree;

/**
 * 序列化二叉树： 请实现两个函数，分别用来序列化和反序列化二叉树
 * 思路：通过前序遍历序列化二叉树
 * @author dyh
 *
 */

public class SerializeTree {

	int index = -1;
	
	String serialize(TreeNode root){
		if(root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		serizlize2(root, sb);
		return sb.toString();
	}

	void serizlize2(TreeNode root, StringBuilder sb){
		if(root == null){
			sb.append("!,");
			return;
		}
		sb.append(root.val);
		sb.append(',');
		serizlize2(root.left, sb);
		serizlize2(root.right, sb);
	}
	
	TreeNode deserialize(String str){
		if(str.length() == 0){
			return null;
		}
		String[] strs = str.split(",");
		return deserialize2(strs);
	}
	
	TreeNode deserialize2(String[] strs){
		index ++;
		if(!strs[index].equals("!")){
			TreeNode root = new TreeNode(0);
			root.val = Integer.parseInt(strs[index]);
			root.left = deserialize2(strs);
			root.right = deserialize2(strs);
			return root;
		}
		return null;
	}
	

}
