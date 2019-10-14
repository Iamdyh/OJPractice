package com.dyh.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Words That Can Be Formed by Characters: You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 * input:words = ["cat","bt","hat","tree"], chars = "atach"
 * output:6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6. 
 * @author dyh
 *
 */

public class FindWordsThatCanBeFormedbyCharacters {
	
	public static int countCharacters(String[] words, String chars) {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
        	if(isContains(words[i], chars)) {
        		count += words[i].length();
        	}
        }
        return count;
    }
	
	public static boolean isContains(String world, String chars) {
		char[] arr = new char[26];
		char[] aimArray  = chars.toCharArray();
		char[] charArray = world.toCharArray();
		for(int i = 0; i < aimArray.length; i++) {
			char c = aimArray[i];
			arr[c - 'a'] ++;
		}
		for(int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if(arr[c - 'a'] <= 0) {
				return false;
			}
			arr[c - 'a']--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"cat","bt","hat","tree"};
		String chars = "atach";
		System.out.println(countCharacters(words, chars));
	}

}
