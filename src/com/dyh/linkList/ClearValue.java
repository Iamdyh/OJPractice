package com.dyh.linkList;

/**
 * 链表指定值清除练习题: 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 * 例：{1,2,3,4,3,2,1},2
 * 返回：{1,3,4,3,1}
 * 思路：利用两个节点，当一个节点temp的值等于val时，那么另一个节点p的next指针就指向temp.next,否则就p = temp,遍历链表。
 * @author dyh
 *
 */

public class ClearValue {
	 public static  ListNode clear(ListNode head, int val) {
	        // write code here
		 if(head == null)
			 return null;
		 ListNode p = head;
		 ListNode temp = p;
		 while(temp != null) {
			 if(temp == head && temp.val == val) {
				 head = temp.next;
			 }else if(temp.val == val) {
				 p.next = temp.next;
				 
			 }else {
				 p = temp;
			 }
			temp = temp.next;
		 }
		 return head;
	 }
	 public static void main(String[] args) {
		 int[] arr = {1,2,3,4,3,2,1};
		 int val = 2;
		 ListNode head = ListNode.createList(arr);
		 head = clear(head, val);
		 ListNode.printList(head);
	 }
}
