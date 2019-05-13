package com.dyh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find Common Characters：Given an array A of strings made only from lowercase letters, 
 * return a list of all characters that show up in all strings within the list (including duplicates).  
 * For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * You may return the answer in any order.
   *  例：["bella","label","roller"]
   *  返回：["e","l","l"]
 * @author dyh
 *
 */

public class FindCommonCharacters {

	/**
	   * 使用字典统计每个字符串中的每个字符的次数，然后对26个字符进行遍历，统计在所有字符串中这个字符出现的最少次数，把该最小次数个该字符放到结果列表中即可。
	 * @param A
	 * @return
	 */
	public static List<String> commonChars(String[] A) {
	     List<String> list = new ArrayList<String>();
	     int[] characters = new int[26];                          //代表26个字母
	     int[] num = new int[26];                                 //26个字母的数量
	     for(int i = 0; i < 26; i++) {
	    	 characters[i] = 10000;
	     }
	     for(String s: A) {
	    	 for(int i = 0; i < 26; i++) {
	    		 num[i] = 0;
	    	 }
	    	 for(int i = 0; i < s.length(); i++) {
	    		 num[s.charAt(i) - 'a'] ++;
	    	 }
	    	 for(int i = 0; i < 26; i++) {
	    		 characters[i] = Math.min(characters[i], num[i]);         //统计在所有字符串中这个字符出现的最少次数
	    	 } 
	    	 
	     }
	     for(int i = 0; i < 26; i++) {
	    	 if(characters[i] > 0) {
	    		 char ch = (char)('a' + i);
	    		 String string = ch + "";
	    		 for(int j = 0; j < characters[i]; j++) {
	    			 list.add(string);
	    		 }
	    		 
	    	 }
	     }
	     
	     
	     return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub                                             
		String[] A = {"bella","label","roller"};
 		List<String> res = commonChars(A);
		for(int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		
	}

}
