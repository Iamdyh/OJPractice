package com.dyh.linkList;



/**
 * 访问单个节点的删除练习题：实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的头节点和要删除的数字，请执行删除操作，返回删除后的头结点。链表中没有重复数字
 * 例：1->2->3->4->5, 3
 * 返回：1->2->4->5
 * 思路：利用两个指针,
 * @author dyh
 *
 */

public class Remove {
	
	
	public ListNode removeNode(ListNode pNode, int delVal) {
	        // write code here
		
		if(pNode.next == null) {
			return null;
		}
		//当头节点的值等于删除值时，直接返回头节点的next
		if(pNode.val == delVal) {
			return pNode.next;
		}
		int tempVal = 0;
		ListNode next = pNode.next;
		ListNode pre = pNode;
		//当要删除的值在链表中时，遍历链表，直到找到需要删除的节点，然后将当前节点的上一个节点指向
		//当前节点的下一个节点，这就完成了删除操作。
		while(next != null && next.val != delVal) {
			pre = next;
			next = next.next;
		}
		pre.next = next.next;
		return pNode;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int delVal = 3;
		Remove remove = new Remove();
		ListNode head = ListNode.createList(arr);
		head = remove.removeNode(head, delVal);
		ListNode.printList(head);
	}

}
