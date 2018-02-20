package com.dyh.probability;

import java.util.Arrays;

/**
 * 足球比赛练习题:有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
 * 例：4
 * 返回：[3,7]
 * 思路：利用组合数学，分别计算出分子和分母：
 * 1、首先求出8只球队分成4组比赛的方法数：7*5*3*1 = 105
 * 2、没有两强相遇的方法数：C(5,3)*A(3,3) = 60, C(5,3):从5只弱队中选出3只弱队的方法
 * A(3,3):3只强队和3只弱队彼此配对的方法数
 * 3、两强不相遇的概率：(105-60)/105 = 3/7
 * @author dyh
 *
 */

public class Championship {
	
	public static int[] calc(int k) {
		int total = 1;
		for(int i = 2*k-1; i > 1; i = i-2) {
			total *= i;          //总数
		}
		int notMeet = 1;
		int num = k+1;   //k+1只弱队
		for(int i = 1; i <= k-1; i++) {
			notMeet *= (num--);
		}
		int gcd = gcd(total - notMeet, total);
		int[] res = new int[2];
		res[0] = (total - notMeet) / gcd;
		res[1] = total / gcd;
		return res;
		
	}
	
	//辗转相除法求最大公约数
	public static int gcd(int meet, int total) {
		if(meet % total == 0)
			return total;
		return gcd(total, meet%total);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 4;
		System.out.println(Arrays.toString(calc(k)));
	}

}
