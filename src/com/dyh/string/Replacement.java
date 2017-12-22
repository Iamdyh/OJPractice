package com.dyh.string;

/**
 * 空格替换练习题：请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 * 例："Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * 思路：新建一个StringBuilder对象sb，遍历原来的string，如果遇到空格sb后就添加%20,否则就添加string。
 * @author dyh
 *
 */

public class Replacement {
	/**
	 * 
	 * @param iniString
	 * @param length
	 * @return
	 */
	public static String replaceSpace(String iniString, int length) {
        // write code here
		
		StringBuilder sb = new StringBuilder();
		char t;
		for(int i = 0; i < length; i++) {
			t = iniString.charAt(i);
			if(t == ' ') {
				sb.append("%20");
			}else {
				sb.append(t);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Mr John Smith";
		System.out.println(replaceSpace(string, 13));
	}

}
