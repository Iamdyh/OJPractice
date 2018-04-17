package com.dyh.array;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字： 0，1，... n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 思路：这是典型的约瑟夫环问题。
 * @author dyh
 *
 */

public class CircleSolution {

	public static int lastRemaingSolution(int n, int m){
		if(n == 0)
			return -1;
		ArrayList<Integer> array = new ArrayList<>();
		for(int i = 0; i < n; i++){
			array.add(i);
		}
		int temp = (m-1) % array.size(); //记录最初需清除的数字索引
		while(array.size() != 1){
			array.remove(temp);
			temp = (temp + (m-1))%array.size(); //记录当前索引
		}
		return array.get(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int m = 5;
		System.out.println(lastRemaingSolution(n, m));
	}

}
