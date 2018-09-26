package com.dyh.string;

/**
 * 正则表达式匹配：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author dyh
 *
 */

public class RegexSolution {
	public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
        	return false;
        }
        return matchCore(str, 0, pattern, 0);
    }
	
	public boolean matchCore(char[] str, int index1, char[] pattern, int index2){
		//有效性检验：str到尾，pattern到尾，匹配成功
		if(index1 == str.length && index2 == pattern.length){
			return true;
		}
		//pattern先到尾，匹配失败
		if(index1 != str.length && index2 == pattern.length){
			return false;
		}
		//模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
		if(index2 + 1 < pattern.length && pattern[index2 + 1] == '*'){
			if((index1 != str.length && pattern[index2] == str[index1]) || (pattern[index2] == '.' && index1 != str.length)){
				return matchCore(str, index1, pattern, index2 + 2) //模式后移2，视为x*匹配0个字符
						|| matchCore(str, index1+1, pattern, index2 + 2) //视为模式匹配1个字符
						|| matchCore(str, index1+1, pattern, index2);//*匹配1个，再匹配str中的下一个
			}else{
				return matchCore(str, index1, pattern, index2 + 2);
			}
			
		}
		//模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if((index1 != str.length) && pattern[index2] == str[index1] || ((pattern[index2] == '.' && index1 != str.length))){
			return matchCore(str, index1 + 1, pattern, index2 + 1);
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'a', 'a', 'a'};
		char[] pattern = {'a', 'a', '*','*', 'a', 'c', '*', 'a'};
		RegexSolution re = new RegexSolution();
		System.out.println(re.match(str, pattern));

	}

}
