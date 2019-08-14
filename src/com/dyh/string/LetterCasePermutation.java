package com.dyh.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Case Permutation:Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
 * Return a list of all possible strings we could create.
 * input: S = "a1b2"
 * output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * @author dyh
 *
 */

public class LetterCasePermutation {
	
	//思路:递归排列组合出所有可能,利用异或运算转换字母大小写。
	public static List<String> letterCasePermutation(String S) {
       List<String> list = new ArrayList<>();
       transform(S.toCharArray(), 0, list);
       return list;
    }
	
	public static void transform(char[] ch, int index, List<String> list) {
		if(index == ch.length) {
			list.add(String.valueOf(ch));
			return;
		}
		transform(ch, index + 1, list);
		if(ch[index] < '0' || ch[index] > '9') {
			ch[index] ^= (1 << 5);                     //大小写字母切换
			transform(ch, index + 1, list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "A1b2";
		System.out.println(letterCasePermutation(string).toString());
	}

}
