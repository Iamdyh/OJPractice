package com.dyh.binaryTree;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 二叉树的实现
 * @author dyh
 *
 */
public class BinaryTree {
	
	int val;
	BinaryTree left;
 	BinaryTree right;
 	
 	static int counter = 0;   //定义一个静态计数变量
 	
 	public BinaryTree(){
 		
 	}
 	public BinaryTree(int val, BinaryTree left, BinaryTree right){
 		this.val = val;
 		this.left = left;
 		this.right = right;
 	}
 	
 	/**
 	 * 创建二叉树
 	 * @param root
 	 * @param a
 	 * @param i
 	 * @return
 	 */
	
 	public static BinaryTree createBitree(BinaryTree root, int[] a, int i){
 		if(i < a.length){
 			if(a[i] == 0){ //0表示该节点为空
 				root = null;
 			}else{
 				BinaryTree left = new BinaryTree();
 				BinaryTree right = new BinaryTree();
 				root.val = a[i];
 				root.left = createBitree(left, a, ++counter);
 				root.right = createBitree(right, a, ++counter);
 				
 			}
 		}
 		return root;
 	}
 	
 	/**
 	 * 前序遍历递归算法
 	 * @param root
 	 */
 	public static void preOrder1(BinaryTree root){
 		if(root == null)
 			return;
 		else{
 			visitNode(root);
 			preOrder1(root.left);
 			preOrder1(root.right);
 		}
 	}
 	
 	/**
 	 * 前序遍历非递归算法
 	 * @param root
 	 */
 	public static void preOrder2(BinaryTree root){
 		Stack<BinaryTree> stack = new Stack<BinaryTree>();
 		BinaryTree p = root;
 		while(p != null || stack.size() > 0){
 			while(p != null){
 				visitNode(p);
 				stack.push(p);
 				p = p.left;
 			}
 			if(stack.size() > 0){
 				p = stack.pop();
 				p = p.right;
 			}
 		}
 	}
 	
 	/**
 	 * 中序遍历递归算法
 	 * @param root
 	 */
 	public static void inOrder1(BinaryTree root){
 		if(root == null)
 			return;
 		else{
 			inOrder1(root.left);
 			visitNode(root);
 			inOrder1(root.right);
 		}
 	}
 	
 	/**
 	 * 中序遍历递归算法
 	 * @param root
 	 */
 	public static void inOrder2(BinaryTree root){
 		Stack<BinaryTree> stack = new Stack<BinaryTree>();
 		BinaryTree p = root;
 		while(p != null || stack.size() > 0){
 			while(p != null){
 				stack.push(p);
 				p = p.left;
 			}
 			if(stack.size() > 0){
 				p = stack.pop();
 				visitNode(p);
 				p = p.right;
 			}
 		}
 	}
 	
 	/**
 	 * 后序遍历递归算法
 	 * @param root
 	 */
 	public static void postOrder1(BinaryTree root){
 		if(root == null)
 			return;
 		else{
 			postOrder1(root.left);
 			postOrder1(root.right);
 			visitNode(root);
 		}
 	}
 	/**
 	 * 后序遍历非递归算法（单栈法）
 	 * @param root
 	 */
 	public static void postOrder2(BinaryTree root){
 		Stack<BinaryTree> stack = new Stack<BinaryTree>();
 		BinaryTree p = root, pre = root;
 		while(p != null || stack.size() > 0){
 			while(p != null){
 				stack.push(p);
 				p = p.left;
 			}
 			if(stack.size() > 0){
 				BinaryTree temp = stack.peek().right;
 				if(temp == null || temp == pre){
 					p = stack.pop();
 					visitNode(p);
 					pre = p;
 					p = null;
 				}else{
 					p = temp;
 				}
 			}
 		}
  	}
 	/**
 	 * 后序遍历非递归算法（双栈法）：
 	 * @param root
 	 */
 	public static void postOrder3(BinaryTree root){
 		Stack<BinaryTree> stack = new Stack<BinaryTree>();
 		Stack<BinaryTree> temp = new Stack<BinaryTree>();
 		BinaryTree p = root;
 		while(p != null || stack.size() > 0){
 			while(p != null){
 				stack.push(p);
 				temp.push(p);
 				p = p.right;
 			}
 			if(stack.size() > 0){
 				p = stack.pop();
 				p = p.left;
 			}
 		}
 		while(temp.size() > 0){
 			p = temp.pop();
 			visitNode(p);
 		}
 	}
 	
 	/**
 	 * 层序遍历
 	 * @param root
 	 */
 	public static void levelOrder(BinaryTree root){
 		if(root == null)
 			return;
 		ArrayList<Integer> list = new ArrayList<Integer>();
 		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
 		queue.offer(root);
 		while(!queue.isEmpty()){
 			BinaryTree p = queue.poll();
 			if(p.left != null){
 				queue.offer(p.left);
 			}
 			if(p.right != null){
 				queue.offer(p.right);
 			}
 			list.add(p.val);
 		}
 		
 		for(int i = 0; i < list.size(); i++){
 			System.out.print(list.get(i)+ " ");
 		}
 	}
 	
 	/**
 	 * 访问节点
 	 * @param node
 	 */
 	public static void visitNode(BinaryTree node){
 		System.out.print(node.val + " ");
 	}
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree root = new BinaryTree();
		int[] a = {1,2,3,0,0,4,0,0,5,0,0};
		root = createBitree(root, a, counter);
		//preOrder1(root);
		//preOrder2(root);
		
		
		//inOrder1(root);
		//inOrder2(root);
		
		/*postOrder1(root);
		postOrder2(root);
		postOrder3(root);*/

		levelOrder(root);
	}

}
