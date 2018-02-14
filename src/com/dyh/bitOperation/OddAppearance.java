package com.dyh.bitOperation;

/**
 * 寻找奇数出现练习题:有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定整形数组A及它的大小n，请返回题目所求数字。
 * 例：[1,2,3,2,1], 5
 * 返回：3
 * 思路：利用异或， n与0异或结果为n， n与n异或结果为0.异或满足结合率和交换率
 * @author dyh
 *
 */

public class OddAppearance {

	public static int findOdd(int[] A, int n) {
        // write code here
		int res = 0;
		for(int i = 0; i < n; i++) {
			res ^= A[i];
		}
		return res;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,2,1};
		System.out.println(findOdd(A, 5));
	}

}
