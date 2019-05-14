package com.dyh.string;

/*
 * Reverse String:Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
   * 例：["h","e","l","l","o"]
   * 返回：["o","l","l","e","h"]
 * 
 */

public class ReverseString {
	
	public static void reverseString(char[] s) {
        int last = s.length - 1;
        char temp;
        for(int i = 0; i < s.length/2; i++, last--) {
        	temp = s[i];
        	s[i] = s[last];
        	s[last] = temp;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = {'h','e','l','l','o'};
		reverseString(s);
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

}
