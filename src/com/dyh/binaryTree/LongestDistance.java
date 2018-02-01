package com.dyh.binaryTree;

/**
 * 树上最远距离练习题：从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。
 * 对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500。
 * 思路：1、整个过程为后序遍历，在二叉树的每棵子树上执行步骤2。
 *     2、假设子树头为h，处理h左子树，得到两个信息，左子树上的最大距离记为LMax1，左子树上距离h左孩子的最远距离记为LMax2。
 *     处理h右孩子的最远距离记为RMax2。那么跨h节点情况下的最大距离为LMax2+1+RMax2，这个值与LMax1和RMax1比较，最大值为
 *     以头的树上的最大距离。
 *     3、LMax2+1就是h左子树上离h最远的点到h的距离，RMax2+1就是h右子树上离h最远的点到h的距离，
 *     选两者中最大的一个作为h树上距离h最远d距离返回。
 * @author dyh
 *
 */

public class LongestDistance {
	public static int findLongest(TreeNode root) {
		// write code here
		int[] record = new int[1];
		return postOrder(root, record);
	}
	public static int postOrder(TreeNode node, int[] record) {
		if(node == null) {
			record[0] = 0;
			return 0;
		}
		int LMax1 = postOrder(node.left, record);
		int LMax2 = record[0];
		int RMax1 = postOrder(node.right, record);
		int RMax2 = record[0];
		int curNodeMax = LMax2 + RMax2 + 1;
		record[0] = Math.max(LMax2, RMax2) + 1;
		return Math.max(Math.max(LMax1, LMax2), curNodeMax);
	}
}
