package com.dyh.string;
/**
 * 最长无重复字符子串练习题:对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 * 例："aabcb",5
 * 返回：3
 * @author dyh
 *
 */

public class DistinctSubstring {
	
	/**
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public static int longestSubstring(String A, int n) {
        // write code here
		//哈希表map:用来统计每种字符之前出现的位置，重复的字符的位置就在map中更新。
		//pre: 代表以s[i-1]结尾的情况下，最长无重复子串的长度。根据当前最长无重复字符字串的长度，更新pre。
		if(A == null || n == 0)
			return 0;
		char[] arr = A.toCharArray();
		int[] map = new int[256];
		for(int i = 0; i < 256; i++) {
			map[i] = -1;
		}
		int cur = 0;
		int len = 0;
		int pre = -1;
		for(int i = 0; i < n; i++) {
			
			pre = Math.max(pre, map[arr[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[arr[i]] = i;
		}
		return len;
		
    }
	
	public static int longestSubstring2(String A, int n) {
		//map用来记录字符出现的位置，如果有重复字符，则更新到最右边的位置。
		//start用来记录每个字符出现的次数。
		if(A == null || n == 0)
			return 0;
		char[] arr = A.toCharArray();
		int[] map = new int[256];
		for(int i = 0; i < 256; i++) {
			map[i] = -1;
		}
		int len = 0;
		int start = 1;
		
		for(int i = 1; i <= n; i++) {
			if(map[arr[i-1]] >= start) {
				start = map[arr[i-1]] + 1;
				map[arr[i-1]] = i;
			}else{
				map[arr[i-1]] = i;
				len = Math.max(len, i - start + 1);
			}
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string ="aabcb";
		//System.out.println(longestSubstring(string, 5));
		System.out.println(longestSubstring2(string, 5));
	}

}
