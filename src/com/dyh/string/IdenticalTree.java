package com.dyh.string;

/**
 * 拓扑结构相同子树练习题:
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 * 思路：1、将二叉树序列化，变成字符串；
 *      2、利用kmp算法，查看A中是否包含B。
 * @author yanhaolu
 *
 */

public class IdenticalTree {
	public static class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val) {
			this.val = val;
		}
 	}
	
	public static boolean chkIdentical(TreeNode A, TreeNode B) {
		String str1 = serialByPre(A);
		String str2 = serialByPre(B);
		System.out.println(str1);
		System.out.println(str2);
		return kmpSearch(str1, str2) != -1;
	}
	
	/**
	 * 利用前序遍历序列化二叉树
	 * @param head
	 * @return
	 */
	public static String serialByPre(TreeNode head) {
		if(head == null) {
			return "#!";
		}
		String res = head.val + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	//KMP算法
	
	public static int kmpSearch(String source, String pattern) {
		int i = 0, j = 0;
		char[] src = source.toCharArray();
		char[] ptn = pattern.toCharArray();
		int sLen = src.length;
		int pLen = ptn.length;
		int[] next = getNext(ptn);
		while(i < sLen && j < pLen) {
			 // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
			if(j == -1 || src[i] == ptn[j]) {
				i++;
				j++;
			}else {
				// 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
				j = next[j];
			}
			
		}
		if(j == pLen)
			return i-j;
		return -1;
	}

	public static int[] getNext(char[] p) {
		// 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
		int len = p.length;
		int[] next = new int[len];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < len-1) {
			//p[k]表示前缀，p[j]表示后缀   
			if(k == -1 || p[j] == p[k]) {
				++k;
				++j;
				if(p[j] != p[k]) {
					next[j] = k;
				}else {
					//因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]  
	                next[j] = next[k];  
				}
			}else {
				k = next[k];
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(5);
		A.left.left = new TreeNode(3);
		A.left.right = new TreeNode(4);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		
		TreeNode B = new TreeNode(5);
		B.left = new TreeNode(6);
		B.right = new TreeNode(7);
		
		System.out.println(chkIdentical(A, B));
		
	}

}
