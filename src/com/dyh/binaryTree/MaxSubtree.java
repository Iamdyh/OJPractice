package com.dyh.binaryTree;

/**
 * 最大二叉搜索子树练习题:有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点。
 * 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 * 可能的情况：1、来自root左子树上的最大搜索二叉子树是以root左孩子为头的，并且来自root右子树上的最大搜索二叉子树是以
 *         root右孩子为头的，root左子树上的最大搜索二叉子树的最大值小于root节点值，root右子树上的最大搜索二叉子树的最小值大于
 *         root的节点值，那么以节点root为头的整棵树都是搜索二叉树。
 *         2、如果不满足第一种情况，说明以节点root为头的树整体不能连成搜索二叉树。这种情况下，以root为头的树上的最大搜索二叉子树
 *         是来自root的右子树上的最大搜索二叉子树之间，节点数较多的那个。
 * 思路：1、整体过程是二叉树的后序遍历。
 *     2、遍历到当前节点记为cur时，先遍历cur的左子树并收集4个信息，分别是左子树上，最大搜索二叉子树的头节点、节点数、
 *     树上最小值和树上最大值。再遍历cur的右子树收集4个信息，分别是右子树上最大搜索二叉子树的头节点、节点数、最小值和
 *     最大值。
 *     3、根据步骤2所收集的信息，判断是否满足第一种情况，也就是是否以cur为头的子树，整体都是搜索二叉树。如果满足第一种
 *     情况，就返回cur节点，如果满足第二种情况，就返回左子树和右子树各自的最大搜索二叉树中，节点数较多的那个树的头节点。
 * @author dyh
 *
 */
public class MaxSubtree {
	public static TreeNode getMax(TreeNode root) {
		// write code here
		if(root == null)
			return null;
		int[] record = new int[3];
		return postOrder(root, record);
    }
	
	public static TreeNode postOrder(TreeNode root, int[] record) {
		if(root == null) {
			record[0] = Integer.MIN_VALUE;
			record[1] = Integer.MAX_VALUE;
			record[2] = 0;
			return null;
		}
		TreeNode lNode = postOrder(root.left, record);
		//0：最大值，1：最小值，2：总节点数
		int lMax = record[0];  
		int lMin = record[1];
		int lSum = record[2];
		TreeNode rNode = postOrder(root.right, record);
		int rMax = record[0];
		int rMin = record[1];
		int rSum = record[2];
		
		//更新最大值
		record[0] = Math.max(rMax, root.val);
		//更新最小值
		record[1] = Math.min(lMin, root.val);
		
		if(lNode == root.left && rNode == root.right && lMax < root.val && rMin > root.val) {
			record[2] = rSum + lSum + 1;
			return root;
		}
		record[2] = Math.max(rSum, lSum);
		return rSum >= lSum ? rNode : lNode;
	}
}
