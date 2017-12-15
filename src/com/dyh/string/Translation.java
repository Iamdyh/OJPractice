package com.dyh.string;
/**
 * 字符串移位练习题:对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 * 例："ABCDE", 5, 3
 * 返回："DEABC"
 * 思路：1、先将0到len间的字符进行逆序调整；
 *      2、再将len到n间的字符进行逆序调整；
 *      3、最后对整体进行逆序调整。
 * @author yanhaolu
 *
 */
public class Translation {
	public static String stringTranslation(String A, int n, int len) {
        // write code here
		if(A == null || n == 0 || len == 0)
			return A;
		char[] chs = A.toCharArray();
		//0...len进行交换
		reverse(chs, 0, len-1);
		//len...n进行交换
		reverse(chs, len, n-1);
		//0...n进行交换
		reverse(chs, 0, n-1);
		return new String(chs);
    }

	public static void reverse(char[] str, int start, int end) {
		char temp = 0;
		while(start < end) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABCDE";
		System.out.println(stringTranslation(str, 5, 3));

	}

}
