package com.dyh.string;
/**
 * 合法括号序列判断练习题:对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 例："(()())",6
 * 返回： true
 * 思路：1、新建一个整型变量count，
 *		2、遍历string，遇到'(', 则count++;
 *      3、遇到')', 则count--;
 *      4、如果 count<0, 则返回false;
 *      5、遍历完string后，如果count == 0，返回true，否则返回false。
 * @author dyh
 *
 */

public class Parenthesis {
	/**
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public static boolean chkParenthesis(String A, int n) {
        // write code here
		int count = 0;
		char[] arr = A.toCharArray() ;
		for(int i = 0; i < n; i++) {
			if(arr[i] == '(')
				count++;
			else if(arr[i] == ')')
				count--;
			if(count < 0)
				return false;
		}
		if(count == 0)
			return true;
		else
			return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "(()())";
		System.out.println(chkParenthesis(string, 6));
	}

}
