package com.dyh.string;

/**
 * 两串旋转练习题:如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
 * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 * 例："cdab",4 "abcd", 4
 * 返回： true
 * 思路：1、先判断两个字符串长度是否相等，不等在返回false；
 * 		2、将字符串A和B相加生成一个新的字符串string_new，然后利用kmp算法，查看string_new中是否包含B，包含就返回true，否则就返回false。
 * @author dyh
 *
 */

public class Rotation {
	/**
	 * 
	 * @param A
	 * @param lena
	 * @param B
	 * @param lenb
	 * @return
	 */
	public static boolean chkRotation(String A, int lena, String B, int lenb) {
	        // write code here
		if(lena != lenb)
			return false;
		String string_new = A + B;
		return kmpSearch(string_new, B) != -1;
		
	}
	//kmp算法
	public static int kmpSearch(String source, String pattern) {
		int i = 0, j = 0;
		char[] src = source.toCharArray();
		char[] ptn = pattern.toCharArray();
		int sLen = src.length;
		int pLen = ptn.length;
		int[] next = getNext(ptn);
		while(i < sLen && j < pLen) {
			 // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
			if(j == -1 || src[i] == ptn[j]) {
				i++;
				j++;
			}else {
				// 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
				j = next[j];
			}
			
		}
		if(j == pLen)
			return i-j;
		return -1;
	}

	public static int[] getNext(char[] p) {
		// 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
		int len = p.length;
		int[] next = new int[len];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < len-1) {
			//p[k]表示前缀，p[j]表示后缀   
			if(k == -1 || p[j] == p[k]) {
				++k;
				++j;
				if(p[j] != p[k]) {
					next[j] = k;
				}else {
					//因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]  
	                next[j] = next[k];  
				}
			}else {
				k = next[k];
			}
		}
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string_A = "cdab";
		String string_B = "abcd";
		System.out.println(chkRotation(string_A, 4, string_B, 4));

	}

}
