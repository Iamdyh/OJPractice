package com.dyh.linkList;

/**
 * 复杂链表的复制练习题:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 思路：先将各个节点复制一遍，放到被复制节点的后面，然后遍历链表，为复制节点的random赋值，最后将大链表分开。
 * @author dyh
 *
 */

public class Solution {
	static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public static RandomListNode Clone(RandomListNode pHead)
    {
		if(pHead == null)
			return null;
        RandomListNode pTemp = pHead;
        //遍历链表，复制节点,并将复制节点放在该节点之后
        while(pTemp != null) {
        		RandomListNode pTempNew = new RandomListNode(pTemp.label);
        		pTempNew.next = pTemp.next;
        		pTemp.next = pTempNew;
        		pTemp = pTemp.next.next;
        }
        pTemp = pHead;
        RandomListNode pNewNode = null;
        RandomListNode pNewNext = null;
        //给复制的那些节点的random赋值
        while(pTemp != null) {
        	pNewNext = pTemp.next.next;
            pNewNode = pTemp.next;
            pNewNode.random = pTemp.random != null ? pTemp.random.next : null;
            pTemp = pNewNext;
        	}
        
        //将大链表分开
        pTemp = pHead;
        RandomListNode pNewHead = pHead.next;
       
        while(pTemp != null) {

        		pNewNext = pTemp.next.next;
        		pNewNode = pTemp.next;
        		pTemp.next = pNewNext;
        		pNewNode.next = pNewNext != null ? pNewNext.next : null;
        		pTemp = pNewNext;
        	
        }
        return pNewHead;
    }
	
	
	
	public static void main(String[] args) {
		RandomListNode p1 = new RandomListNode(1);
		RandomListNode p2 = new RandomListNode(2);
		RandomListNode p3 = new RandomListNode(3);
		p1.next = p2;
		p1.random = p3;
		p2.next = p3;
		p2.random = p1;
		p3.next = null;
		p3.random = p2;
		
		RandomListNode pRes = Clone(p1);
		while(pRes != null) {
			System.out.println(pRes.label);
			pRes = pRes.next;
		}
		
	}

}
