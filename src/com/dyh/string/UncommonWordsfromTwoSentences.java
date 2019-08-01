package com.dyh.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Uncommon Words from Two Sentences：We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * Return a list of all uncommon words. 
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output:["sweet", "sour"]
 * @author dyh
 *
 */

public class UncommonWordsfromTwoSentences {
	
	//每个不常见的单词总共只出现一次。我们可以统计每个单词的出现次数，然后返回恰好出现一次的单词。
	public static String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word: A.split(" ")) {
        	map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(String word: B.split(" ")) {
        	map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> res = new LinkedList<String>();
        for(String word: map.keySet()) {
        	if(map.get(word) == 1) {
        		res.add(word);
        	}
        }
        
        return res.toArray(new String[res.size()]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "apple apple";
		String b = "banana";
		System.out.println(Arrays.toString(uncommonFromSentences(a, b)));
		
	}

}
