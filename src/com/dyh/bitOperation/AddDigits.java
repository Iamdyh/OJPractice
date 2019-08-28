package com.dyh.bitOperation;
/**
 * Add Digits:Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * input:38
 * output:2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * @author dyh
 *
 */

public class AddDigits {
	
	public static int addDigits(int num) {
		
		while(num >= 10) {
			int sum = 0;
			for(char c : Integer.toString(num).toCharArray()) {
				sum += c - '0';
			}
			num = sum;
		}
        return num;
    }
	 /*
    	经过简单的列举，得到如下数字
    	1——9，返回1——9
    	10——18，返回1——9
    	19——27，返回1——9
    	28——36，返回1——9
    	....
    	规律总结，每9个数字为一组，计算的结果为1——9
    	所以，只要计算这个数与9的模运算，得到余数，如果余数为0，返回9。如果余数不为0，就为此余数。
     */
	public static int addDigits2(int num) {
		if(num <= 9) {
			return num;
		}else {
			return num%9 == 0?9:num%9;
		}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 388;
		System.out.println(addDigits2(a));
	}

}
