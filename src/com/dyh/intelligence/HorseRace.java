package com.dyh.intelligence;

import java.util.Arrays;

/**
 * 赛马练习题:作为一个马场的主人，你要安排你的n匹赛马和另一个马场的n匹马比赛。你已经知道了对方马场的出战表，即参加每一场的马的强壮程度。
 * 当然你也知道你自己的所有马的强壮程度。我们假定比赛的结果直接由马的强壮程度决定，即更壮的马获胜(若相同则双方均不算获胜)，
 * 请你设计一个策略，使你能获得尽量多的场次的胜利。
 * 给定对方每场比赛的马的强壮程度oppo及你的所有马的强壮程度horses(强壮程度为整数，且数字越大越强壮)同时给定n，请返回最多能获胜的场次。
 * 例：[1,2,3], [1,2,3], 3
 * 返回：2
 * @author dyh
 *
 */

public class HorseRace {
	
	public static int winMost(int[] oppo, int[] horse, int n){
		int count = 0;
		int i = 0;
		int j = 0;
		//先从小到大排序
		Arrays.sort(oppo);
		Arrays.sort(horse);
		while(i < n && j < n){
			if(horse[j] > oppo[i]){
				//如果大于对方，那么获胜场次加1，并且两个都向右移一位。
				count++;
				i++;
				j++;
			}else{
				//小于或等于说明不能获胜，那么就自己的向右移一位。
				j++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] oppo = {1,2,3};
		int[] horse = {1,2,3};
		System.out.println(winMost(oppo, horse, 3));
	}

}
