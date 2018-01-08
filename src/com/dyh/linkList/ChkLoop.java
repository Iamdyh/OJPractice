package com.dyh.linkList;

/**
 * 链表判环练习题:如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 * 思路：利用快、慢两个节点，遍历链表，快节点一次走两步，慢节点一次走一步，当快节点为空或者快节点的
 * 下一个节点为空，说明此链表无环。当快节点和慢节点相遇时，快节点重新从头节点开始遍历，此时快节点一次
 * 走一步，慢节点继续遍历，当两节点再次相遇时，此时的节点就是入环的第一个节点。
 * @author dyh
 *
 */

public class ChkLoop {
	static class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
	}
	public static int chkLoop(ListNode head, int adjust) {
	        // write code here
		//当为空链表或者只有一个节点当链表时，不可能是循环链表，返回-1；
		if(head == null || head.next == null) {
			return -1;
		}
		ListNode pFast = head.next.next;
		ListNode pSlow = head.next;
		//遍历链表，直到pFast为空或者pFast和pSlow相遇
		while(pFast != null && pFast.next != null && pSlow != pFast) {
			pFast = pFast.next.next;
			pSlow = pSlow.next;
		}
		//如果pFast为空，说明没有不是循环链表
		if(pFast == null || pFast.next == null) {
			return -1;
		}
		//给pFast重新赋值，遍历链表，当pFast和pSlow再次相遇时，此节点为入环的第一个节点
		pFast = head;
		while(pFast != pSlow) {
			pFast = pFast.next;
			pSlow = pSlow.next;
		}
		return pFast.val;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		//构造循环链表
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p3;
		
		int res = chkLoop(p1, 0);
		System.out.println(res);
		
	}

}
