package com.dyh.array;

/**
 * 左旋转字符串：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 思路：1、先将0到len间的字符进行逆序调整；
 *      2、再将len到n间的字符进行逆序调整；
 *      3、最后对整体进行逆序调整。
 * @author dyh
 *
 */

public class StringTranslation {
	
	public static String LeftRotateString(String str,int n) {
		if(str == null || str.length() < 1)
			return "";
		char[] chs = str.toCharArray();
		reverse(chs, 0, n-1);
		reverse(chs, n, str.length()-1);
		reverse(chs, 0, str.length()-1);
		return new String(chs);
	}
	
	public static void reverse(char[] ch, int left, int right){
		char temp;
		while(left < right){
			temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;
			left++;
			right--;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "abcXYZdef";
		System.out.println(LeftRotateString(string, 3));
	}

}
