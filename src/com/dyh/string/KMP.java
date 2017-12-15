package com.dyh.string;

public class KMP {
	
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
		String source = "abcdefgefgsge";
		String pattern = "efgs";
		int res = kmpSearch(source, pattern);
		System.out.println(res);
	}

}
