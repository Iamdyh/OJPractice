package com.dyh.string;
/**
 * Remove Outermost Parentheses:有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 
 * input:"(()())(())"
 * output:"()()()"
 * @author dyh
 *
 */

public class RemoveOutermostParentheses {

	//可以通过将左右括号赋不同的值（比如左括号每有一个加1，右括号加-1）
	//由于括号的对称性，可以看出只要是左括号'('其值大于0就应该加入，右括号')'只要大于0就加入
	public static String removeOuterParentheses(String S) {
        int len = S.length();
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < len; i++) {
        	char c = S.charAt(i);
        	if(c == '(') {
        		if(count > 0) {
        			sb.append(c);
        		}
        		count++;
        	}else if(c == ')') {
        		count--;
        		if(count > 0) {
        			sb.append(c);
        		}
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "(()())(())";
		System.out.println(removeOuterParentheses(string));
	}

}
