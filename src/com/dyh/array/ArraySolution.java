package com.dyh.array;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路：设两个值，small = 1, big = 2。当s + b 小于sum时，b增加，计算s到b之间的值，再和 sum比较，当s到b之间的值大于sum时，
 * 去掉最小的值，即增大s的值。直到s到(1+sum)/2为止。
 * @author dyh
 *
 */

public class ArraySolution {
	
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
		int small = 1;
		int big = 2;
		int mid = (1+sum)/2;
		while(small < mid){
			int cursum = sum(small, big);
			if(cursum == sum){
				ArrayList<Integer> list = new ArrayList<>();
				for(int i = small; i <= big; i++){
					list.add(i);
					
				}
				arrayLists.add(list);
				small++;
				big++;
			}else if(cursum < sum){
				big++;
			}else{
				small++;
			}
		}
		return arrayLists;
	}
	
	public static int sum(int left, int right){
		int sum = left;
		for(int i = left+1; i <= right; i++){
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindContinuousSequence(15));
	}

}
