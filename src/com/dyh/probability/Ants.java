package com.dyh.probability;

import java.util.Arrays;

/**
 * 蚂蚁习题：n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
 * 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
 * 例：3
 * 返回：[3,4]
 * 思路：一只蚂蚁有两种走法，所以n只蚂蚁有2的n次方走法，不碰头的话只可能是都是顺时针走或者都是逆时针走，
 * 所以碰头的概率就是：2的n次方-2/2的n次方
 * @author dyh
 *
 */
public class Ants {
	public static int[] collision(int n) {
		// write code here
		int total = 1;
		for(int i = 0; i < n; i++) {
			total *= 2;
		}
		int[] res = new int[2];
		res[0] =(int)total/2 - 1;
		res[1] = (int)total/2;
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(Arrays.toString(collision(3)));
	}

}
