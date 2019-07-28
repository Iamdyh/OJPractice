package com.dyh.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Next Greater Element I：You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * 例： nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 返回：[-1,3,-1]
 * 解释：For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * @author dyh
 *
 */

public class NextGreaterElement {
	
	/**
	 * 通过Stack、HashMap解决
	 * 先遍历大数组nums2，首先将第一个元素入栈；
	 * 继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
	 * 当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
	 * 遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int[] res = new int[len1];
		Stack<Integer> statck = new Stack<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int num: nums2) {
			while(! statck.isEmpty() && statck.peek() < num) {
				hashMap.put(statck.pop(), num);
			}
			statck.push(num);
		}
		for(int i = 0; i < len1; i++) {
			res[i] = hashMap.getOrDefault(nums1[i], -1);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 3, 5, 2, 4};
		int[] nums2 = {6, 5, 4, 3, 2, 1, 7};
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
	}

}
