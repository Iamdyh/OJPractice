package com.dyh.string;

/**
 * Reverse Words in a String III：Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * 例："Let's take LeetCode contest"
 * 返回："s'teL ekat edoCteeL tsetnoc"
 * @author dyh
 *
 */

public class ReverseWordsInAStringIII {
	
	public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        String res = "";
        for(int i = 0; i < strings.length; i++) {
        	String t = reverse(strings[i]);
        	if(i != strings.length - 1) {
        		res += t + " "; 
        	}else {
        		res += t;
        	}
        }
        return res;
    }
	
	public static String reverse(String word) {
		int len = word.length();
		char[] chars = word.toCharArray();
		for(int i = 0; i < len/2; i++) {
			char temp = chars[i];
			chars[i] = chars[len-1- i];
			chars[len - 1 - i] = temp; 
		}
		return new String(chars);
	}
	
	//改：
	public static String reverseWords2(String s) {
		char[] chars = s.toCharArray();
		for(int i = 0, j = 0; j < chars.length; j++) {
			if(chars[j] == ' ' || j == chars.length - 1) {
				int x = (j == chars.length - 1) ? j : j-1;
				reverse2(chars, i, x);
				i = j+1;
			}
		}
		return new String(chars);
	}
	
	public static void reverse2(char[] ch, int i, int j) {
		if(i >= j)
			return;
		while(i < j) {
			char t = ch[i];
			ch[i++] = ch[j];
			ch[j--] = t;
 		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Let's take LeetCode contest";
		System.out.println(reverseWords2(string));
	}

}
