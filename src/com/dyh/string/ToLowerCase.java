package com.dyh.string;

/**
 * 将大写字母转换成小写
 * 例："Hello"
 * 返回："hello"
 * @author dyh
 *
 */

public class ToLowerCase {

	public static String toLowerCase(String str) {
        if(str == null || str.length() < 1){
        	return null;
        }
        char[] res = new char[str.length()];
        int count = 0;
        for(int i = 0; i < str.length(); i++){
        	if(str.charAt(i)>= 'A' && str.charAt(i) <= 'Z'){
        		res[count++] = (char) (str.charAt(i) + 32);
        	}else{
        		res[count++] = str.charAt(i);
        	}
        }
        return new String(res);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "LOVELY";
		System.out.println(toLowerCase(string));
	}

}
