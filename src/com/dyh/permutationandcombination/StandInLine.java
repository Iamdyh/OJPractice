package com.dyh.permutationandcombination;

/**
 * 站队问题练习题:n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？
 * 给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。
 * 例：7，1，2
 * 返回：[2520, 720]
 * @author dyh
 *
 */

public class StandInLine {

	public static int[] getWays(int n, int a, int b) {
	        // write code here
		int[] res = new int[2];
		res[0] = fac(n)/2; // a在b的左边，不一定相邻
		res[1] = fac(n-1); // a在b的左边，一定相邻
		return res;
    }
	/**
	 * 求阶乘
	 * @param s
	 * @return
	 */
	public static int fac(int s) {
		int res = s;
		for(int i = s-1; i > 0; i--) {
			res = res * i;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int a = 0;
		int b = 0;
		System.out.println(getWays(n, a, b));
	}

}
