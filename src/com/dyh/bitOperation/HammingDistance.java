package com.dyh.bitOperation;

/**
 * Hamming Distance:汉明距离：两个二进制数，不相同的个数即汉明距离
   *  例：x = 1, y = 4
   *  返回：2，  因为1： 0001 ，4：0100 
 * @author dyh
 *
 */

public class HammingDistance {
	
	//原
	public static int hammingDistance(int x, int y) {
        //根据题意，两个数异或即为所求
		int z = x^y;
		String string = Integer.toBinaryString(z);
		int count = 0;
		for(char ch: string.toCharArray()) {
			if(ch == '1') {
				count++;
			}
		}
		return count;
    }
	
	//改
	public static int hammingDistance2(int x, int y) {
		int count = 0;
		while(x != 0 || y != 0) {
			if(x % 2 != y %2) {
				count++;
			}
			x = x/2;
			y = y/2;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		int y = 4;
		System.out.println(hammingDistance2(x, y));
	}

}
