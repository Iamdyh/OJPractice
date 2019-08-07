package com.dyh.bitOperation;

/**
 * Complement of Base 10 Integer:每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
 * input: 5
 * output: 2
 * @author dyh
 *
 */
public class ComplementOfBase10Integer {
	
	public static int bitwiseComplement(int N) {
		
       if(N == 0) {
    	   return 1;
       }
       int t = N;
       int mask = 1;
       while(t > 0) {
    	   mask <<= 1;
    	   t >>= 1;
       }
       return N ^ (mask-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		System.out.println(bitwiseComplement(N));
	}

}
