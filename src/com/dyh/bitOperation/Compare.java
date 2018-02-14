package com.dyh.bitOperation;

/**
 * 比较练习题:对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。
 * 给定两个整数a和b，请返回较大的数。
 * 例：1，2
 * 返回： 2
 * 思路：只要知道a-b的符号就可以知道返回a，还是b
 * @author dyh
 *
 */

public class Compare {
	public  static int getMax(int a, int b) {
        // write code here
		int c = a - b;
		int as = sign(a); //a的符号，as == 1表示a为非负， as == 0表示a为负
		int bs = sign(b); //b的符号，bs == 1表示b为非负， bs == 0表示b为负
		int cs = sign(c); //a-b的符号
		int difab = as ^ bs; //表示a和b是否符号不相同，不相同为1，相同为0
		int sameab = flip(difab); //表示a和b是否符号相同，相同为1， 不相同为0
		int returnA = difab * as + sameab * cs;
		int returnB = flip(returnA);
		return a*returnA + b*returnB;
    }
	/**
	 * 取得32位整数符号
	 * @param n
	 * @return
	 */
	public static int sign(int n) {
		return flip((n >> 31) & 1);
	}
	public static int flip(int n) {
		return n ^ 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 2;
		System.out.println(getMax(a, b));
	}

}
