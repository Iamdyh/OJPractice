package com.dyh.linkList;

/**
 * 有环单链表相交判断练习题:如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 * 例：hea1->p1->p2->p3->p4->p2, head2->p5->p2->p3->p4->p2;
 * 返回：p2
 * 思路：先找到两个链表的入环节点，如果两入环节点相等，那么再查看入环节点之前有没有相交节点（通过判断无环单链表是否相交的方法），
 * 如果入环节点之前没有相交节点，那么返回入环节点；如果入环节点不相等，那么存在两种情况：情况一：两个链表不相交，返回null，
 * 情况二：两个链表共用一个环， 返回任意一个入环节点即可。
 * @author dyh
 *
 */

public class ChkIntersection {

	public static ListNode chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
		if(head1 == null || head1.next == null || head2 == null || head2.next == null)
			return null;
		ListNode res = null;
		ListNode pNode_1 = head1;
		ListNode pNode_2 = head2;
		
		//先找到两个链表的入环节点：
		ListNode pFirstLoopNode_1 = findFirstLoopNode(head1);
		ListNode pFirstLoopNode_2 = findFirstLoopNode(head2);
		
		
		if(pFirstLoopNode_1 != null && pFirstLoopNode_2 != null) {
			//如果两个链表的入环节点相等，说明两个链表相交，然后再找两个链表之前有没有相交节点
			if(pFirstLoopNode_1 == pFirstLoopNode_2) {
				 res = findFirstInterserctNode(pNode_1, pNode_2, pFirstLoopNode_1);
				 if(res == null) {
					 //如果之前没有相交点，那么返回入环公共节点
					 res = pFirstLoopNode_1;
				 }
			}else {
				//如果入环节点不相等，则有两种情况:
				//遍历链表,不能遍历循环链表，运行时间太长
				//情况一：两个链表公用一个环，返回任意一个入环节点都行
				ListNode cur = pFirstLoopNode_1.next;
				while(cur != pFirstLoopNode_1) {
					if(cur == pFirstLoopNode_2) {
						res = cur;
					}
					cur = cur.next;
				}
				//情况二：两个链表不相交，返回null;
				res = null;
			}
		}
		return res;
    }
	
	/**
	 * 找到两个链表的相交节点
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode findFirstInterserctNode(ListNode headA, ListNode headB, ListNode common) {
		if(headA == common || headB == common)
			return null;
		ListNode pNodeA = headA;
		ListNode pNodeB = headB;
		int lenA = 0;
		int lenB = 0;
		int res = 0;
		//遍历A链表
		while(pNodeA != common) {
			lenA++;
			pNodeA = pNodeA.next;
		}
		//遍历B链表
		while(pNodeB != common) {
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
			
			while(pNodeA != common) {
				if(pNodeA == pNodeB) {
					return pNodeA;
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
			
			while(pNodeA != common) {
				if(pNodeA == pNodeB) {
					return pNodeA;
				}
				pNodeA = pNodeA.next;
				pNodeB = pNodeB.next;
			}
		}else {
			//两链表长度相同，一起走
			pNodeA = headA;
			pNodeB = headB;
			while(pNodeA != common) {
				if(pNodeA == pNodeB) {
					return pNodeA;
				}
				pNodeA = pNodeA.next;
				pNodeB = pNodeB.next;
			}
		}
		return null;
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
		ListNode head_1 = new ListNode(0);
		ListNode head_2 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		ListNode p6 = new ListNode(6);
		
		ListNode p7 = new ListNode(7);
		ListNode p8 = new ListNode(8);
		ListNode p9 = new ListNode(9);
		
		//链表一：head_1->p2->p3->p4->p5->p6->p3;
		head_1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p3;
		
		//链表二：head_2->p7->p3->p4->p5->p6->p3;
		head_2.next = p7;
		p7.next = p3;
		
		System.out.println(chkInter(head_1, head_2, 0, 0).val);
		
		
		
		
	}

}
