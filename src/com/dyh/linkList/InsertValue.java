package com.dyh.linkList;

import java.awt.List;

/**
 * 环形链表插值练习题:有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * 例：[1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 * 思路：利用两个指针变量，同步移动。
 * 
 * @author dyh
 * 
 *
 */

public class InsertValue {
	
	public ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
		if(A == null || A.length == 0) {
			return null;
		}
		ListNode head = new ListNode(A[0]);
		ListNode p = head;
		//构建循环链表
		for(int i = 1; i < A.length; i++) {
			p.next = new ListNode(A[i]);
			p = p.next;
		}
		p.next = head;
		
		p = head;
		ListNode q = head.next;
		ListNode temp = null;
		//插入的值在链表中间部分时
		while(q != head) {
			if(p.val < val && q.val >= val) {
				temp = new ListNode(val);
				temp.next = p.next;
				p.next = temp;
				return head;
			}
			p = p.next;
			q = q.next;
		}
		//插入的值比所有数都小时
		if(q.val >=  val) {
			temp = new ListNode(val);
			temp.next = q;
			p.next = temp;
			head = temp;
		}else if(p.val < val) {
			//插入的值比所有值大时
			temp = new ListNode(val);
			temp.next = q;
			p.next = temp;
		}
		return head;
    }
	//牛课网能通过的
	public ListNode insert2(int[] A, int[] nxt, int val) {
		  // write code here
        if(A.length == 0){
            ListNode curNode = new ListNode(val);
            //curNode.next= curNode;
            return curNode;
        }
        //构造环形链表
        int len = A.length;
        ListNode head= new ListNode(A[0]);
         ListNode tail = head;
        for(int i=0;i<len-1;i++){
            ListNode curNode = new ListNode(A[nxt[i]]);
            tail.next = curNode; 
            tail = curNode;
        }
         //tail.next = head;
        
         
        //插入值
        ListNode preNode = head;
        ListNode nextNode = preNode.next;
        //当val小于等于链表中最小值时
        if(head.val>=val){
            ListNode curNode = new ListNode(val);
            curNode.next = head;
            //tail.next = curNode;
            return curNode;
        }
        //遍历循环链表，直到找到循环链表中比val小的节点
        while(nextNode!=null&&val>nextNode.val){
            preNode = nextNode;
            nextNode = preNode.next;
        }
         
        ListNode curNode = new ListNode(val);
        curNode.next = nextNode;
        preNode.next = curNode;
        return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,8,9};
		int[] nxt = {1,2,3,4,0};
		int val = 4;
		InsertValue insertValue = new InsertValue();
		ListNode head = insertValue.insert2(A, nxt, val);
		ListNode.printList(head);
	}

}
