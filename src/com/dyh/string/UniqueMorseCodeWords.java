package com.dyh.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给一串字符，将它们翻译成摩斯码，求一共有多少中不同的摩斯码
 * 26个字母对应的摩斯码
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 例：words=["gin", "zen", "gig", "msg"]
 * "gin" -----> "--...-."
 * "zen" -----> "--...-."
 * "gig" -----> "--...--."
 * "msg" -----> "--...--."
 * 返回：2
 * @author dyh
 *
 */

public class UniqueMorseCodeWords {

	private static final String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	public static int uniqueMorseRepresentations(String[] words) {
        Set<String> code = new HashSet<>();   
        for(String word: words){
        	code.add(getLetterToMorse(word));    //使用Set集合保存莫斯码，保证不会有重复的元素，所以code的大小即为所求
        }
		return code.size();
    }
	
	public static String getLetterToMorse(String string){
		StringBuilder sb = new StringBuilder();
		for(char c: string.toCharArray()){
			sb.append(MORSE[c-'a']);          // c-'a':获取MORSE码中对应的下标
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
	}

}
