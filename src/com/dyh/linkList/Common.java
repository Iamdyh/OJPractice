package com.dyh.linkList;

import java.util.ArrayList;

/**
 * 打印两个链表的公共值练习题:现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。
 * 请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 * 例：{1,2,3,4,5,6,7},{2,4,6,8,10}
 * 返回：[2,4,6]
 * 思路：遍历两个链表，从头开始比较两个链表的值，如果相等就放入数组中，并且两个链表都向后移动，如果headA.val>headB.val,则headB向后移动
 * 否则，headA向后移动，一旦某个链表的指向null，那么就结束遍历。
 * @author dyh
 *
 */

public class Common {
	
	public static int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
		if(headA == null || headB == null)
			return null;
		ArrayList<Integer> list =  new ArrayList<>();
		while(headA != null && headB != null) {
			if(headA.val < headB.val) {
				headA = headA.next;
			}else if(headA.val > headB.val) {
				headB = headB.next;
			}else {
				list.add(headA.val);
				headA = headA.next;
				headB = headB.next;
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,7};
		int[] B = {2,4,6,8,10};
		ListNode headA = ListNode.createList(A);
		ListNode headB = ListNode.createList(B);
		int[] res = new int[3];
		res = findCommonParts(headA, headB);
		for(int i = 0; i < 3; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
