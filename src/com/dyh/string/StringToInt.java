package com.dyh.string;

/**
 * 把字符串转换成整数：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 思路：边界条件：
 * 数据上下溢出
 * 空字符串
 * 只有正负号
 * 有无正负号
 * 错误标志输出
 * @author dyh
 *
 */

public class StringToInt {
	
	public static int strToInt(String str){
		int res = 0;
		int symbol = 1;                 //符号
		boolean isInvalid = false;      //区分非法输入和0
		char[] ch = str.toCharArray();
		int len = str.length();
		if(str == null || len <= 0){
			isInvalid = true;
			return 0;
		}
		if(ch[0] == '-'){
			//如果是负数
			symbol = -1;
		}
		for(int i = (ch[0] == '-' || ch[0] == '+' ? 1 : 0); i < len; ++i){
			if(!(ch[i] >= '0' && ch[i] <= '9')){
				isInvalid = true;
				return 0;
			}
			
			res = res * 10 + ch[i] - '0';
			
			//溢出判断
			if((symbol == 1 && res > Integer.MAX_VALUE) || (symbol == -1 && res < Integer.MIN_VALUE)){
				isInvalid = true;
				return 0;
			}
		}
		
		return res*symbol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "-123456789";
		System.out.println(strToInt(str));
	}

}
