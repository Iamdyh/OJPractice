package com.dyh.linkList;

/**
 * Middle of the Linked List:Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * @author dyh
 *
 */


public class MiddleOfTheLinkedList {
	
	public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
        	count ++;
        	temp = temp.next;
        }
        temp = head;
        if(count % 2 != 0) {
        	int mid = count / 2;
        	while(mid > 0) {
        		mid--;
        		temp = temp.next;
        	}
        	return temp;
        }else {
        	int mid = count / 2;
        	while(mid > 1) {
        		mid--;
        		temp = temp.next;
        	}
        	return temp.next;
        }
        
       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
