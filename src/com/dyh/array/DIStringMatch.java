package com.dyh.array;

import java.util.Arrays;

/**
 * DI String Match：题目的意思是，将字符串与数组一一对应，因为数组多一位，不考虑这一位。剩下的位置，如果字符串写的是‘I’，那么该位置上的数应该比右边所有的数都小。而如果是‘D’，则是比右边的都大。现在需要找到其中任意一组。
 * 例："IDID"
 * 返回：[0,4,1,3,2]
 * @author dyh
 *
 */
public class DIStringMatch {

	public static int[] diStringMatch(String S) {
        if(S == null || S.length() == 0){
        	return null;
        }
        int len = S.length();
        int[] res = new int[len+1];
        int first = 0;
        int last = len;
        for(int i = 0; i < len; i++){
        	if(S.charAt(i) == 'I'){
        		res[i] = first;
        		first++;
        	}else if(S.charAt(i) == 'D'){
        		res[i] = last;
        		last--;
        	}
        	if(i == len-1){
        		if(S.charAt(i) == 'I'){                             //最后一个特殊处理
            		res[i+1] = res[i] + 1;
            		
            	}else if(S.charAt(i) == 'D'){
            		res[i+1] = res[i] - 1;
            		
            	}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "IDID";
		System.out.println(Arrays.toString(diStringMatch(string)));
	}

}
