package com.dyh.sort;

import java.util.Arrays;
/**
 * 基数排序
 * 时间复杂度：平均情况：O(d(r+n)),最好情况：O(d(n+rd)),最坏情况：O(d(r+n));
 * 空间复杂度：辅助存储：O(rd+n)
 * 稳定性：稳定
 * r代表关键字的基数，d代表长度，n代表关键字的个数
 * @author dyh
 *
 */

public class RadixSort {
	public static int[] radixSort(int[] A, int n){
		 if(A==null||n<2) 
			 return null;
	        int a=1,m=1;
	        int index=0;
	        int[]count = new int[10];
	        int[][] number = new int [10][n];
	        while(m<4){
	            for (int i = 0; i < A.length; i++) {
	                int lsd = (A[i]/a)%10;
	                number[lsd][count[lsd]++] =A[i];
	            }
	             for(int j=0;j<count.length;j++){
	                if (count[j]!=0) {
	                    for (int k = 0; k < count[j]; k++) {
	                        A[index++]=number[j][k];
	                    }
	                }
	                count[j]=0;
	             }
	             index=0;
	             a*=10;
	             m++;
	        }
	        return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,1,5,7,2,4,8,6};
		a = radixSort(a, 8);
		System.out.println(Arrays.toString(a));
	}

}
