package com.dyh.linkList;

/**
 * 删除链表中重复的结点：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author dyh
 *
 */
public class DeleteDuplication {

	public static ListNode deleteDuplication(ListNode pHead)
    {
		ListNode pFirst = new ListNode(-1);
		pFirst.next = pHead;
		ListNode p = pHead;
		ListNode pLast = pFirst;
		while(p != null && p.next != null){
			if(p.val == p.next.val){
				int val = p.val;
				while(p != null && p.val == val){
					p = p.next;
				}
				pLast.next = p;
			}else{
				pLast = p;
				p = p.next;
			}
		}
		return pFirst.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(3);
		ListNode p5 = new ListNode(4);
		ListNode p6 = new ListNode(4);
		ListNode p7 = new ListNode(5);
		
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		
		p1 = deleteDuplication(p1);
		ListNode.printList(p1);
	}

}
