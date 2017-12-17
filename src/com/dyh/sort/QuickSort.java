package com.dyh.sort;

import java.util.Arrays;
/**
 * 快速排序
 * 时间复杂度：平均情况：O(nlog2n),最好情况：O(nlog2n),最坏情况：O(n2);
 * 空间复杂度：辅助存储：O(nlog2n)
 * 稳定性：不稳定
 * 
 * 当原表有序或基本有序时，直接插入排序和冒泡排序将大大减少比较次数和移动记录的次数，时间复杂度可降至O（n）；
 * 而快速排序则相反，当原表基本有序时，将蜕化为冒泡排序，时间复杂度提高为O（n2）；
 * 原表是否有序，对简单选择排序、堆排序、归并排序和基数排序的时间复杂度影响不大。
 * 
 * 
 * 排序算法的稳定性:若待排序的序列中，存在多个具有相同关键字的记录，经过排序， 这些记录的相对次序保持不变，
 * 则称该算法是稳定的；若经排序后，记录的相对 次序发生了改变，则称该算法是不稳定的。
 * 
 *  
 * 设待排序元素的个数为n.
1）当n较大，则应采用时间复杂度为O(nlog2n)的排序方法：快速排序、堆排序或归并排序序。
   快速排序：是目前基于比较的内部排序中被认为是最好的方法，当待排序的关键字是随机分布时，快速排序的平均时间最短；
       堆排序 ：  如果内存空间允许且要求稳定性的，
       归并排序：它有一定数量的数据移动，所以我们可能过与插入排序组合，先获得一定长度的序列，然后再合并，在效率上将有所提高。
2）  当n较大，内存空间允许，且要求稳定性 =》归并排序
3）当n较小，可采用直接插入或直接选择排序。
    直接插入排序：当元素分布有序，直接插入排序将大大减少比较次数和移动记录的次数。
    直接选择排序 ：元素分布有序，如果不要求稳定性，选择直接选择排序
5）一般不使用或不直接使用传统的冒泡排序。
6）基数排序
它是一种稳定的排序算法，但有一定的局限性：
　　1、关键字可分解。
　　2、记录的关键字位数较少，如果密集更好
　　3、如果是数字时，最好是无符号的，否则将增加相应的映射复杂度，可先将其正负分开排序。
 */


public class QuickSort {
	
	public static void quicSort(int[] arr){
		if(arr == null || arr.length < 2)
			return;
		process(arr, 0, arr.length - 1);
	}
	public static void process(int[] arr, int left, int right){
		if(left < right){
			int mid = partition(arr, left, right);
			process(arr, left, mid - 1);
			process(arr, mid+1, right);
		}
	}
	public static int partition(int[] arr, int left, int right){
		int i = left;
		int j = right;
		while(i < j){
			while( i < j && arr[i] <= arr[j])
				j--;           //�Ҳ�ɨ��
			if(i < j){
				swap(arr, i, j);
				i++;
			}
			while(i < j && arr[i] <= arr[j])
				i++;           //���ɨ��
			if(i < j){
				swap(arr,i,j);
				j--;
			}
		}
		return i;         //iΪ��ֵ��¼������λ��
	}
	
	public static void swap(int[] arr, int index1, int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,3,0,6,9,0,1,2,4,5};
		quicSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
