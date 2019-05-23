package com.dyh.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Shortest Distance to a Character：Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *   例：S = "loveleetcode", C = 'e'
 *   返回：[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * @author dyh
 *
 */

public class ShortestDistanceToACharacter {
	
	public static int[] shortestToChar(String S, char C) {
		int len = S.length();
		int[] res = new int[len];
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < len; i++) {
			if(S.charAt(i) == C) {
				list.add(i);                  //将和C相等元素的下标记录下来
			}
		}
		for(int i = 0; i < len; i++) {
			int min = Math.abs(i - list.get(0));
			for(int j : list) {
				min = Math.min(min, Math.abs(i - j));
			}
			res[i] = min;
			
		}
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "loveleetcode";
		char ch = 'e';
		System.out.println(Arrays.toString(shortestToChar(string, ch)));
	}

}
