package com.dyh.string;

/**
 * 表示数值的字符串：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符
 * 串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author dyh
 *
 */

public class IsNumericSolution {

	public static boolean isNumeric(char[] str) {
        if(str == null || str.length < 1)
        	return false;
        int len = str.length;
        //标记符号
        boolean sign = false;
        //小数点
        boolean decimal = false;
        //e是否出现过，e后面一定要接数字
        boolean hasE = false;
        for(int i = 0; i < len; i++){
        	
        
        	//对于e的判断
        	if(str[i] == 'e' || str[i] == 'E'){
        		if(i == len-1){
        			return false;   //如果最后一个字符是e或者E，那么就返回false， 因为e后面要接数字
        		}
        		if(hasE){
        			return false;   //不能存在两个e
        		}
        		hasE = true;
        	}else if(str[i] == '+' || str[i] == '-'){
        		//对于正负符号的判断
        		if(sign && str[i-1] != 'e' && str[i-1] != 'E'){
        			return false;   //第二次出现+，-符号，则必须紧接在e之后
        		}
        		if(!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E'){
        			return false;   //第一次出现+，-符号，且不是在字符串开头，也必须紧接在e之后
        		}
        		sign = true;
        	}else if(str[i] == '.'){
        		//对于小数点的判断
        		if(hasE || decimal){
        			return false;   //e后面不能接小数点，小数点不能出现两次
        		}
        		decimal = true;
        	}else if(str[i] < '0' || str[i] > '9'){
        		//对于不属于0~9的字符的判断
        		return false;
        	}
        	
        }
        return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "5e-6";
		System.out.println(isNumeric(string.toCharArray()));
	}

}
