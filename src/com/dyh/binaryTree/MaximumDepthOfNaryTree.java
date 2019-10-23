package com.dyh.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Maximum Depth of N-ary Tree：给定一个 N 叉树，找到其最大深度。最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * input: 3叉树
 * output:3
 * @author dyh
 *
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class MaximumDepthOfNaryTree {
	
	//采用递归，N叉树的最大深度等于它的最大子树深度+1，递归遍历其所有子树，取深度最大的结果+1即为结果。
	public int maxDepth(Node root) {
		if(root == null) {
			return 0;
		}
		int dep = 0;
		for(Node node : root.children) {
			int d = maxDepth(node);
			dep = Math.max(dep, d);
		}
		
        return dep + 1;
    }



}
