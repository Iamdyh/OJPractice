package com.dyh.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Occurrences After Bigram:Given words first and second, consider occurrences in some text of the form "first second third", where second comes 
 * immediately after first, and third comes immediately after second.
 * For each such occurrence, add "third" to the answer, and return the answer.
 * input:text = "alice is a good girl she is a good student", first = "a", second = "good"
 * output:["girl","student"]
 * @author dyh
 *
 */

public class OccurrencesAfterBigram {
	
	public static String[] findOcurrences(String text, String first, String second) {
		  String[] strings = text.split(" ");
			List<String> list = new ArrayList<>();
			int count = 0;
			for(int i = 0; i < strings.length - 2; i++) {
				if(strings[i].equals(first) && strings[i+1].equals(second)) {
					list.add(strings[i+2]);
						
				}
			}
			return list.toArray(new String[list.size()]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String textString = "alice is a good girl she is a good student";
		String first = "a";
		String second = "good";
		System.out.println(Arrays.toString(findOcurrences(textString, first, second)));
	}

}
