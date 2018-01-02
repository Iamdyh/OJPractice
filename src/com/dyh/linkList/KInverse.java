package com.dyh.linkList;

import java.util.Stack;

/**
 * 链表的k逆序练习题:有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，
 * 因为只有两个节点不够一组。给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 * 
 * 思路：利用栈，以k个数为一组放入栈中，然后从栈依次弹出重组链表。
 * 
 * @author dyh
 *
 */

public class KInverse {
	
	public static ListNode inverse(ListNode head, int k) {
	        // write code here
		if(head == null) {
			return null;
		}
		int len = 0;
		ListNode p = head;
		while(p != null) {
			len++;
			p = p.next;
		}
		if(len < k || k < 2 || len <= 1) {
			return head;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode pNode = head;
		ListNode pTemp = null;
		int index = 0;
		int count = 0;
		//利用len/k可以知道一共有几组数据需要逆序
		while(count < (len / k )) {
			if(index < k) {
				stack.push(pNode);
				index++;
				pNode = pNode.next;
			}else {
				while(!stack.isEmpty()) {
					pTemp = ListNode.insertList(pTemp, stack.pop().val);
				}
				index = 0;
				count++;
			}
		
		}
		while(pNode != null) {
			pTemp = ListNode.insertList(pTemp, pNode.val);
			pNode = pNode.next;
		}
		return pTemp;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,2,5,11};
		int k = 2;
		ListNode head = ListNode.createList(arr);
		head = inverse(head, k);
		ListNode.printList(head);
	}

}
