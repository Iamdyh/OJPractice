package com.dyh.linkList;

import java.util.Stack;

/**
 * 链表的回文结构练习题:请编写一个函数，检查链表是否为回文。给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 例：{1,2,3,2,1}
 * 返回： true
 * 例：{1,2,3,2,3}
 * 返回： false
 * 思路：方法一：利用一个栈stack，遍历节点，压入栈中，然后所有栈中节点弹出，然后和链表节点的值一一比较，
 * 			   如果中间有一个值不相等，那么返回false，如果栈为空，那么说明所有节点的值相等，那么返回
 * 			   true
 *      方法二：利用两个节点，遍历链表找到中间节点，将中间节点后半部分逆序，然后从链表两头遍历节点，比较它们的值。
 * @author dyh
 *
 */

public class Palindrome {
	/**
	 * 方法一：时间复杂度为O(n),空间复杂度为O(n)
	 * @param pHead
	 * @return
	 */

	public static boolean isPalindrome1(ListNode pHead) {
	        // write code here
		if(pHead == null || pHead.next == null)
			return true;
		Stack<ListNode> stack = new Stack<>();
		ListNode p  = pHead;
		while(p != null) {
			stack.push(p);
			p = p.next;
		}
		p = pHead;
		while(p != null && !stack.isEmpty()) {
			if(p.val == stack.peek().val) {
				p = p.next;
				stack.pop();
			}else {
				return false;
			}

			
		}
		
		return true;
    }
	
	/**
	 * 方法二：时间复杂度为O(n), 空间复杂度为O(1)
	 * @param pHead
	 * @return
	 */
	public static boolean isPalindrome2(ListNode pHead) {
        // write code here
		if (pHead == null || pHead.next == null) {
			return true;
		}
		ListNode n1 = pHead;
		ListNode n2 = pHead;
		while (n2.next != null && n2.next.next != null) { // 找到中间节点
			n1 = n1.next; // n1 -> mid
			n2 = n2.next.next; // n2 -> end
		}
		n2 = n1.next; // n2 -> right part first node
		n1.next = null; // mid.next -> null
		ListNode n3 = null;
		while (n2 != null) { // right part convert
			n3 = n2.next; // n3 -> save next node
			n2.next = n1; // next of right node convert
			n1 = n2; // n1 move
			n2 = n3; // n2 move
		}
		n3 = n1; // n3 -> save last node
		n2 = pHead;// n2 -> left first node
		boolean res = true;
		while (n1 != null && n2 != null) { // check palindrome
			if (n1.val != n2.val) {
				res = false;
				break;
			}
			n1 = n1.next; // left to mid
			n2 = n2.next; // right to mid
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) { // recover list
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 2, 1};
		int[] arr2 = {1,2,3,2,3};
		ListNode pHead1 = ListNode.createList(arr);
		ListNode pHead2 = ListNode.createList(arr2);
		
		System.out.println(isPalindrome1(pHead1));
		System.out.println(isPalindrome2(pHead2));
	}

}
