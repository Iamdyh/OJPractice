package com.dyh.binaryTree;

/**
 * 对称的二叉树：请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author dyh
 *
 */

public class TreeSymmetrical {
	public static boolean isSymmetrical(TreeNode pRoot){
		return isSame(pRoot, pRoot);
	}
	
	public static boolean isSame(TreeNode pLeft, TreeNode pRight){
		if(pLeft == null && pRight == null){
			//说明比较完了
			return true;
		}
		if(pLeft == null || pRight == null){
			//说明左子树或者右子树不相等，所以必然不是对称的
			return false;
		}
		if(pLeft.val != pRight.val){
			return false;
		}
		
		return isSame(pLeft.left, pRight.right) && isSame(pLeft.right, pRight.left);
	}
}
