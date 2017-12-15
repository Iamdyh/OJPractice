package com.dyh.string;
/**
 * 句子逆序问题：对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 * 例："dog loves pig", 13
 * 返回："pig loves dog"
 * 思路：先对句子整体交换，然后再对每个单词交换。
 * @author yanhaolu
 *
 */
public class Reverse {
	public static String reverseSentence(String A, int n) {
		if(A == null || n < 1)
			return A;
		char[] str = A.toCharArray();
		//第一次整体交换
		reverse(str, 0, n-1);
		int l = 0;
		int r = 0;
		while(l < n && r < n) {
			while(l < n && str[l] == ' ') {
				l++;
			}
			r = l;
			while(r < n && str[r] != ' ') {
				r++;
			}
			if(l != r) {
				//每个单词交换
				reverse(str, l, r-1);
				l = r;
			}
		}
		return new String(str);
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
		String string = "dog loves pig";
		System.out.println(reverseSentence(string, 13));
	}

}
