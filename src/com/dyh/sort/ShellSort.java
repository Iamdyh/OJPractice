package com.dyh.sort;

import java.util.Arrays;
/**
 * 希尔排序
 * 时间复杂度：平均情况：O(n1.3),最好情况：O(n),最坏情况：O(n2);
 * 空间复杂度：辅助存储：O(1)
 * 稳定性：不稳定
 * @author dyh
 *  
 */


public class ShellSort {

	
	
	public static void shellsort(int[] a){
		/*int j = 0;
		int temp = 0;
		int len = a.length;
		int dk = len / 2;
		while(dk > 0){
			//System.out.println("dk:" + dk);
			for(int i = dk; i < len; i++){
				temp = a[i];
				for(j = i - dk; j >= 0; j -= dk){
					if(temp < a[j]){
						a[j+dk] = a[j];
					}else{
						break;
					}
				}
				a[j+dk] = temp;
			}
			for(int i = 0; i < len; i++){
				System.out.print(a[i] + " ");
			}
			System.out.println("");
			dk = dk/2;
		}*/
		int d;
		int x, j;
		for(d = a.length/2; d >0; d = d/2){
			
			for(int i = d; i < a.length; i++){
				x = a[i];     //�ڱ�
			
				for(j = i - d; j >= 0 ; j = j - d){
					if(x < a[j]){
						a[j+d]  = a[j];
					}else{
						break;
					}
				}
				a[j+d] = x;    //���뵽��ȷ��λ��
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3,1,5,7,2,4,8,6};
		shellsort(a);
		System.out.println(Arrays.toString(a));
	}

}
