package com.dyh.string;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 拼接最小字典序练习题:对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 * 例：["b", "ba"], 2
 * 返回："bab"
 * 思路：如果s1+s2 < s2+s1,则s1放前面，否则s2放前面。
 * 注意：需要重写比较函数。
 * @author yanhaolu
 *
 */

public class Prior {
	
	
	public static String findSmallest(String[] strs, int n) {
        // write code here
		if(strs == null || n == 0)
			return "";
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o1+o2).compareTo(o2+o1);
			}
		});
		String res = "";
		for(int i = 0; i < n; i++) {
			res += strs[i];
		}
		return res;
			
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"b", "ba"};
		System.out.println(findSmallest(strings, 2));
	}

}
