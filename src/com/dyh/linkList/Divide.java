package com.dyh.linkList;

import java.awt.List;

/**
 * 链表的分化练习题:对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，
 * 大于该值的结点在后面，同时保证两类结点内部的位置关系不变。给定一个链表的头结点head，同时给定阈值val，
 * 请返回一个链表，使小于它的结点在前，等于它的节点放在中间，大于它的在后面。
 * 例：{1,4,2,5}, 3
 * 返回：{1,2,4,5}
 * 思路：新建三个链表，分别存放小于val的节点，等于val的节点，大于val的节点，然后将三个链表重新链接起来。
 * @author dyh
 *
 */
public class Divide {
	public ListNode listDivide(ListNode head, int val) {
        // write code here
		if(head == null) {
			return null;
		}
		ListNode p = head;
		ListNode p1 = null;  //用于构建值小于val的链表
		ListNode p2 = null;  //用于构建值等于val的链表
		ListNode p3 = null;  //用于构建值大于val的链表
		while(p != null) {
			
			if(p.val < val) {
				//构建值小于val的链表
				p1 = ListNode.insertList(p1, p.val);
			}else if(p.val == val) {
				//构建值等于val的链表
				p2 = ListNode.insertList(p2, p.val);
			}else {
				//构建值大于val的链表
				p3 = ListNode.insertList(p3, p.val);
			}
			p = p.next;
		}
		//重新构建链表，将三个链表链接起来
		if(p1 != null) {
			head = p1;
			while(p1.next != null) {
				p1 = p1.next;
			}
			if(p2 != null) {
				p1.next = p2;
				while(p2.next != null) {
					p2 = p2.next;
				}
				p2.next = p3;
				
			}else {
				p1.next = p3;
			}
		}else{
			if(p2 != null) {
				head = p2;
				while(p2.next != null) {
					p2 = p2.next;
				}
				if(p3 != null) {
					p2.next = p3;
				}
			}else {
				head = p3;
			}
		}
		
		return head;
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,3,4,3,2,5};
		int val = 3;
		ListNode head = ListNode.createList(arr);
		Divide divide = new Divide();
		head = divide.listDivide(head, val);
		ListNode.printList(head);

	}

}
