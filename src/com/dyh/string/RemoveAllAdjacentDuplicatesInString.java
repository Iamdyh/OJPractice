package com.dyh.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Remove All Adjacent Duplicates In String:给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * input: "abbaca"
 * output: "ca"
 * @author dyh
 *
 */


public class RemoveAllAdjacentDuplicatesInString {
	
	public static String removeDuplicates(String S) {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		while(flag != -1) {
			flag = isDuplicates(S);
			for(int i = 0; i < S.length(); i++) {
				if(i != flag) {
					sb.append(S.charAt(i));
				}else {
					i++;
				}
			}
			S = sb.toString();
			sb.delete(0,  sb.length());
		}
        return S;
    }
	
	public static String removeDuplicates2(String S) {
		char[] chars = S.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < S.length(); i++) {
			if(stack.isEmpty() || chars[i] != stack.peek()) {
				stack.push(chars[i]);
			}else {
				stack.pop();
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		for(Character c: stack) {
			sBuilder.append(c);
		}
		return sBuilder.toString();
    }
	
	public static int isDuplicates(String s) {
		int index = -1;
		for(int i = 0; i < s.length(); i++) {
			if(i == s.length() - 1) {
				break;
			}
			if(s.charAt(i) == s.charAt(i+1)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "abbaca";
		System.out.println(removeDuplicates(string));
	}

}
