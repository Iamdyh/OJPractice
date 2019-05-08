package com.dyh.array;

/**
 * Delete Columns to Make Sorted:给定一个字符串数组A和一个下标集合D，删除数组A中每个字符串在D中所有元素所对应下标位置处的字符；
 * 计算，最小长度的集合D，使得删除后的字符串数组A中所有字符串对应下标位置处的字符为增序排序；
 * 例：["cba", "daf", "ghi"]
 * 返回：1
 * if D = {1}
 * then A= {"ca", "df", "gi"};
 * 字符串A中所有字符串对应下标位置处的字符为
 * index0: {'c', 'd', 'g'}
 * index2: {'a', 'f', 'i'}
 * @author dyh
 *
 */

public class DeleteColumnsToMakeSorted {
	
	//这道题的目的是想让我们求出最小长度的集合D，其实，我们只需要求出在字符串数组A中有多少个indexi处的字符不满足增序排序，其值就是所要求解的集合D的长度
	public static int minDeletionSize(String[] A) {
		int count = 0;
		int len = A[0].length();
		for(int i = 0; i < len; i++) {
			boolean b = true;
			for(int j = 1; j < A.length; j++) {
				if(A[j].charAt(i) < A[j-1].charAt(i)) {
					b = false;
					break;
				}
			}
			count = b ? count : count + 1;
		}
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"cba", "daf", "ghi"};
		System.out.println(minDeletionSize(a));
	}

}
