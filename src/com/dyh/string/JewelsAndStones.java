package com.dyh.string;

import java.util.HashSet;

/**
 * J:代表宝石，S：代表石头。J和S都是一串字符串，区分大小写，最大长度为50， 现在求多少石头是宝石。
 * 例：J="aA", S="aAAbbbb"
 * 返回：3
 * 思路：在J中找到包含S的字符
 * @author dyh
 *
 */
public class JewelsAndStones {
	//原： O(n2)
	public static int numJewelsInStones(String J, String S){
		int len1 = J.length();
		int len2 = S.length();
		if(len1 < 1 || len1 > 50 || len2 < 1 || len2 > 50){
			return 0;
		}
		char[] cj = J.toCharArray();
		char[] cs = S.toCharArray();
		int count = 0;
		for(int i = 0; i < len1; i++){
			for(int j = 0; j < len2; j++){
				if(cj[i] == cs[j]){
					count++;
				}
			}
		}
		return count;
	}
	
	//改： O(n)
	public static int numJewelsInStones2(String J, String S){
		int len1 = J.length();
		int len2 = S.length();
		if(len1 < 1 || len1 > 50 || len2 < 1 || len2 > 50){
			return 0;
		}
		HashSet<Character> set = new HashSet<>();
		int count = 0;
		for(int i = 0; i < len1; i++){
			set.add(J.charAt(i));
		}
		for(int i = 0; i < len2; i++){
			if(set.contains(S.charAt(i))){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		String j = "abc";
		String string = "Abcabcdacvc";
		System.out.println(numJewelsInStones2(j, string));
	}
}
