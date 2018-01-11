package com.dyh.linkList;

/**
 * 单链表相交判断练习题：给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 * 例：headA->p2->p3, headB->p1->p2->p3
 * 返回：true
 * 思路：见下面注释
 * @author dyh
 *
 */

public class CheckIntersection {
	
	public static boolean chkInter(ListNode headA, ListNode headB, int adjust0, int adjust1) {
		if(headA == null || headB == null)
			return false;
		ListNode pNode_1 = headA;
		ListNode pNode_2 = headB;
		 
		//先判断两个链表是否有环
		ListNode pFirstLoopNode_1 = findFirstLoopNode(headA);
		ListNode pFirstLoopNode_2 = findFirstLoopNode(headB);
		
		if(pFirstLoopNode_1 == null && pFirstLoopNode_2 != null || pFirstLoopNode_2 == null && pFirstLoopNode_1 != null) {
			//如果一个链表有环，一个链表无环，说明两个链表不相交
			return false;
		}else if(pFirstLoopNode_1 == null && pFirstLoopNode_2 == null){
			//如果两个链表无环，利用判断无环单链表相交的方法
			return checkInter(headA, headB);
		}else {
			//如果两个链表都有环，利用判断有环单链表相交的方法
			return checkLoopInter(pFirstLoopNode_1, pFirstLoopNode_2);
		}
	}
	
	/**
	 * 判断有环单链表是否相交
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static boolean checkLoopInter(ListNode head1, ListNode head2) {
		if(head1 == null || head2 == null)
			return false;
		ListNode p1 = head1;
		ListNode p2 = head2;
		if(p1 != null && p2 != null) {
			//如果两个链表的入环节点相等，说明两个链表相交，然后再找两个链表之前有没有相交节点
			if(p1 == p2) {
				 return true;
			}else {
				//如果入环节点不相等，则有两种情况:
				//遍历链表,不能遍历循环链表，运行时间太长
				//情况一：两个链表公用一个环，返回任意一个入环节点都行
				ListNode cur = p1.next;
				while(cur != p1) {
					if(cur == p2) {
						return true;
					}
					cur = cur.next;
				}
				//情况二：两个链表不相交，返回null;
				return false;
			
			}
		}
		return false;
	}
	
	/**
	 * 判断无环单链表是否相交
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static boolean checkInter(ListNode head1, ListNode head2) {
		if(head1 == null || head2 == null)
			return false;
		int n = 0;
		ListNode cur = head1;
		while(cur.next != null) {
			n++;
			cur = cur.next;
		}
		ListNode cur2 = head2;
		while(cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		return cur == cur2;
	}
	
	/**
	 * 找到第一个入环节点，如果是有环单链表的话
	 * @param head
	 * @return
	 */
	public static ListNode findFirstLoopNode(ListNode head) {
		if(head == null || head.next == null)
			return null;
		ListNode pFast = head.next.next;
		ListNode pSlow = head.next;
	    while(pFast != null && pFast.next != null && pFast != pSlow) {
			pFast = pFast.next.next;
			pSlow = pSlow.next;
		}
	    //如果pFast为空，说明没有不是循环链表
	    if(pFast == null || pFast.next == null) {
	    		return null;
	    }
	    //给pFast重新赋值，遍历链表，当pFast和pSlow再次相遇时，此节点为入环的第一个节点
	    	pFast = head;
		while(pFast != pSlow) {
			pFast = pFast.next;
			pSlow = pSlow.next;
		}
		return pFast;
		
	}
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headA = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		headA.next = p2;
		p2.next = p3;
		ListNode headB = new ListNode(0);
		ListNode p1 = new ListNode(4);
		headB.next = p1;
		p1.next = p2;
		System.out.println(chkInter(headA, headB, 0 , 0));
	}

}
