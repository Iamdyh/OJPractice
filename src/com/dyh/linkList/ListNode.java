package com.dyh.linkList;
/**
 * 公共链表类
 * @author dyh
 *
 */

public class ListNode {
	int val;
	ListNode next = null;
	public ListNode(int val) {
		// TODO Auto-generated constructor stub]
		this.val = val;
	}
	//创建链表
	public static ListNode createList(int[] arr) {
		ListNode head = new ListNode(arr[0]);
		ListNode p = head;
		for(int i = 1; i < arr.length; i++) {
			ListNode t = new ListNode(arr[i]);
			p.next = t;
			p = p.next;
		}
		return head;
	}
	//增加节点，在链表尾部增加
	public static ListNode insertList(ListNode head, int val) {
		ListNode p = head;
		if(p == null) {
			p = new ListNode(val);
			return p;
		}
		while(p.next != null) {
			p = p.next;
		}
		ListNode newNode = new ListNode(val);
		p.next = newNode;
		return head;
	}
	//打印链表
	public static void printList(ListNode head) {
		ListNode p = head;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}
}
