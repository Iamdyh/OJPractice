package com.dyh.array;

import java.util.Arrays;

/**
 * Number of Lines To Write String:给出一个长度26的数组widths，保存着26个字母打印出来所需要的的屏幕宽度，而每行屏幕宽度都只有100，超过这个宽度的话，字母只能打印到下一行去，给出一段字符串，求出打印后最后一个字母所在的行数，列数。
 * 例：widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 *    S = "bbbcccdddaaa"
 * 返回：[2, 4]
 * @author dyh
 *
 */
public class NumberOfLinesToWriteString {
	//思路：打印字符串，记录行数row，列数col，如果col大于100，打印到下一行。
	public static int[] numberOfLines(int[] widths, String S) {
		int[] res = new int[2];
        int len = S.length();
        int row = 1;               //从第一行开始
        int col = 0;
        for(int i = 0; i < len; i++) {
        	col += widths[S.charAt(i) - 'a'];        //获得当前字母的宽度
        	if(col > 100) {
        		row ++;            //下一行
        		col = 0;
        		i--;               //重新打印该字母
        	}
        }
        
        res[0] = row;
        res[1] = col;
        return res;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String string = "bbbcccdddaaa";
		System.out.println(Arrays.toString(numberOfLines(widths, string)));
	}

}
