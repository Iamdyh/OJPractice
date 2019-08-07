package com.dyh.bitOperation;

/**
 * Number Complement：给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 例：5
 * 输出：2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * @author dyh
 *
 */

public class NumberComplement {
	
	//如果我们能知道该数最高位的1所在的位置，就可以构造一个长度和该数据所占位置一样长的一个掩码mask，然后概述和mask进行异或即可。
	//例如：5的二进制是101，我们的构造的掩码为mask=111，两者异或则为010，即是所要的结果。
	public static int findComplement(int num) {
       int temp = num;
       int mask = 1;
       while(temp > 0) {
    	   mask <<= 1;
    	   temp >>= 1;
    	   
       }
       return num ^ (mask-1);
   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findComplement(10));
	}

}
