package com.dyh.linkList;

/**
 * 无环单链表判相交练习题:现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 * 例：headA->p1->p2->p3, headB->p4->p5->p2->p3
 * 返回：true
 * 思路：先计算两个链表的长度，然后计算长度的差值为res，然后让长链表走res步，然后两个链表同步走，如果有相等的节点，说明相交，否则不相交。
 * @author dyh
 *
 */

public class CheckIntersect {

	//复杂写法：可以找到第一个相交的节点
	public static boolean chkIntersect(ListNode headA, ListNode headB) {
	        // write code here
		if(headA == null || headB == null)
			return false;
		ListNode pNodeA = headA;
		ListNode pNodeB = headB;
		int lenA = 0;
		int lenB = 0;
		int res = 0;
		//遍历A链表
		while(pNodeA != null) {
			lenA++;
			pNodeA = pNodeA.next;
		}
		//遍历B链表
		while(pNodeB != null) {
			lenB++;
			pNodeB = pNodeB.next;
		}
		
		if(lenA > lenB) {
			//A链表长，先走res步，然后和链表同步走
			pNodeA = headA;
			pNodeB = headB;
			res = lenA - lenB;
			while(res > 0) {
				pNodeA = pNodeA.next;
				res--;
			}
			
			while(pNodeA != null) {
				if(pNodeA == pNodeB) {
					return true;
				}
				pNodeA = pNodeA.next;
				pNodeB = pNodeB.next;
			}
			
		}else if(lenA < lenB){
			//链表长，先走res步，然后和链表同步走
			pNodeA = headA;
			pNodeB = headB;
			res = lenB - lenA;
			
			while(res > 0) {
				pNodeB = pNodeB.next;
				res--;
			}
			
			while(pNodeA != null) {
				if(pNodeA == pNodeB) {
					return true;
				}
				pNodeA = pNodeA.next;
				pNodeB = pNodeB.next;
			}
		}else {
			//两链表长度相同，一起走
			pNodeA = headA;
			pNodeB = headB;
			while(pNodeA != null) {
				if(pNodeA == pNodeB) {
					return true;
				}
				pNodeA = pNodeA.next;
				pNodeB = pNodeB.next;
			}
		}
		return false;
		 
    }
	
	//简便写法:只要最后一个节点相等，就说明相交
	public static boolean chkIntersect2(ListNode headA, ListNode headB) {
		 if(headA==null || headB == null)
	            return false;
	        int n = 0;
	        ListNode cur1 = headA;
	        while(cur1.next!=null){
	            n++;
	            cur1 = cur1.next;
	        }
	        ListNode cur2 = headB;
	        while(cur2.next != null){
	            n--;
	            cur2 = cur2.next;
	        }
	        return cur1 == cur2;
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
		System.out.println(chkIntersect2(headA, headB));
	}

}
