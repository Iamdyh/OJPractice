package com.dyh.binaryTree;
import java.util.ArrayList;

/**
 * 寻找错误结点练习题:一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。
 * 保证二叉树中结点的值各不相同。
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 * 搜索二叉树：每颗子树的头节点的值都比各自左子树上的所有节点值要大，也都比各自
 * 右子树上的所有节点值要小。利用中序遍历后，所得到的值是升序的。
 * 思路：1、对二叉树进行中序遍历，依次出现的节点值会一直升序，如果两个节点值错了，
 *     会出现降序。
 *     2、第一个错误节点为第一次降序时较大的节点，第二个错误节点为最后一次降序
 *     时较小的节点。
 *     
 * @author dyh
 *
 */

public class FindErrorNode {

	
	public static int[] findError(TreeNode root) {
	     // write code here
		ArrayList<Integer> list = new ArrayList<>();
		inOrder(root, list);
		int[] res = new int[2];
		int flag = 0;
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) < list.get(i-1)) {
				if(flag == 0) {//第一个错误点
					res[0] = list.get(i);
					res[1] = list.get(i-1);
					flag = 1;
				}else{
					//第二个错误点
					res[0] = list.get(i);
				}
			}
		}
		
		return res;
	}
	//中序遍历
	public static void inOrder(TreeNode root, ArrayList<Integer> list) {
		if(root == null)
			return;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
