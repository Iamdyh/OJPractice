package com.dyh.string;

import java.awt.datatransfer.StringSelection;

/**
 * Goat Latin: A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * 
 * input: "I speak Goat Latin"
 * output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * @author dyh
 *
 */

public class GoatLatin {
	
	public static String toGoatLatin(String S) {
        if(S == null || S.length() == 0) {
        	return null;
        }
		int count = 0;
		String reString = "";
		String[] strings = S.split(" ");
		for(int i = 0; i < strings.length; i++) {
			char temp = strings[i].charAt(0);
			count = i + 1;
			if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' ||
					temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
				strings[i] += "ma";
				for(int j = 0; j < count; j++) {
					strings[i] += "a";
				}
				
			}else {
				
				strings[i] = strings[i].substring(1);
				
				strings[i] += temp + "ma";
				for(int j = 0; j < count; j++) {
					strings[i] += "a";
				}
			}
		}
		for(int i = 0; i < strings.length; i++) {
			if(i == strings.length - 1) {
				reString += strings[i];
			}else {
				reString += strings[i] + " ";
			}
			
		}
       return reString;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "The quick brown fox jumped over the lazy dog";
		System.out.println(toGoatLatin(string));
	}

}
