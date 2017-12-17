package com.dyh.string;

/**
 * 词语变形练习题:对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * 例："abc",3, "bca",3
 * 返回：true
 * 思路：利用哈希表做字符统计
 * @author yanhaolu
 *
 */

public class Transform {
	public static boolean chkTransform(String A, int lena, String B, int lenb) {
	        // write code here
		if(lena != lenb)
			return false;
		char[] ch_A = A.toCharArray();
		char[] ch_B = B.toCharArray();
		int[] map = new int[256];
		for(int i = 0; i < lena; i++) {
			//统计A中每个字符的次数
			map[ch_A[i]]++;
		}
		for(int i = 0; i < lenb; i++) {
			//先判断每个字符出现的次数是否为0，然后比较后就把当前字符减1
			if(map[ch_B[i]] -- == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string_A = "abc";
		String string_B = "bba";
		System.out.println(chkTransform(string_A, 3, string_B, 3));
	}

}
