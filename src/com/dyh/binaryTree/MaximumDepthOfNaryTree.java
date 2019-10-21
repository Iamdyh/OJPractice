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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node();
		root.val = 1;
		Node node1 = new Node();
		node1.val = 2;
		Node node2 = new Node();
		node2.val = 3;
		Node node3 = new Node();
		node3.val = 4;
		Node node4 = new Node();
		node4.val = 5;
		Node node5 = new Node();
		node5.val = 6;
		List<Node> rootChildren = new ArrayList<Node>();
		rootChildren.add(node1);
		rootChildren.add(node2);
		rootChildren.add(node3);
		List<Node> children3List = new ArrayList<>();
		children3List.add(node4);
		children3List.add(node5);
		root.children = rootChildren;
		node3.children = children3List;
		MaximumDepthOfNaryTree tree = new MaximumDepthOfNaryTree();
		System.out.println(tree.maxDepth(root));
	}

}
