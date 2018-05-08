package com.dyh.string;

/**
 * 字符流中第一个不重复的字符：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author dyh
 *
 */
public class FirstAppearingOnceSolution {

	//用一个int数组表示256个字符
	static int[] count = new int[256];
	static int index = 1;
	public static void Insert(char ch){
        if(count[ch] == 0){
        	count[ch] = index++;
        }else{
        	count[ch] = -1;
        }
    }
  
    public static char FirstAppearingOnce(){
    	int temp = Integer.MAX_VALUE;
    	char ch = '#';
    	for(int i = 0; i < 256; i++){
    		if(count[i] != 0 && count[i] != -1 && count[i] < temp){
    			temp = count[i];
    			ch = (char)i;
    		}
    	}
    	return ch;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "google";
		for(int i = 0; i < string.length(); i++){
			char t = string.charAt(i);
			Insert(t);
		}
		System.out.println(FirstAppearingOnce());
	}

}
