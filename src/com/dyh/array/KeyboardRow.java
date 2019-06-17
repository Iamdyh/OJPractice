package com.dyh.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Keyboard Row:给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。  
   * 例： ["Hello", "Alaska", "Dad", "Peace"]
   * 返回：["Alaska", "Dad"]
 * 
 * @author dyh
 *
 */

public class KeyboardRow {
	
	public static String[] findWords(String[] words) {
        String[] letters = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> list = new ArrayList<String>();
        
        for(String word: words) {
        	if(isMatch(word.toLowerCase(), letters[0])){
        		list.add(word);
        	}else if(isMatch(word.toLowerCase(), letters[1])){
        		list.add(word);
        	}else if(isMatch(word.toLowerCase(), letters[2])){
        		list.add(word);
        	}
        }
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	res[i] = list.get(i);
        }
        return res;
    }
	
	public static boolean isMatch(String word, String letter) {
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			for(int j = 0; j < letter.length(); j++) {
				if(word.charAt(i) == letter.charAt(j)) {
					count ++;
					break;
				}
			}
			
		}
		if(count == word.length()) {
			return true;
		}else {
			return false;
		}
	}
	
	//改
	public static String[] findWords2(String[] words) {
        String[] letters = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> list = new ArrayList<String>();
      
        for(String word: words) {
        	if(isMatch2(word.toLowerCase(), letters)){
        		list.add(word);
        	}
        }
        
        return list.toArray(new String[list.size()]);
    }
	
	public static boolean isMatch2(String word, String[] lettes) {
		boolean match = true;
		String find = null;
		//用首字母判断属于哪一行
		for(String line: lettes) {
			if(line.indexOf(word.charAt(0)) > -1) {
				find = line;
				break;
			}
		}
		if(find == null) {
			match = false;
			return match;
		}
		//判断word字符串是否都属于一行
		for(int i = 1; i < word.length(); i++) {
			if(find.indexOf(word.charAt(i)) < 0) {
				match = false;
				break;
			}
		}
		return match;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] string = {"Hello", "Alaska", "Dad", "Peace"};
		String[] res = findWords2(string);
		for(String s: res) {
			System.out.println(s);
		}
	}

}
