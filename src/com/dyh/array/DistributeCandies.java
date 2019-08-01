package com.dyh.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Distribute Candies：Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
 * input: [1, 1, 2, 2, 3, 3]
 * output: 3
 * 
 * @author dyh
 *
 */
public class DistributeCandies {
	
	
	//最大极端情况，所有糖都不重样，那妹妹也只能得到一半。 中间情况，每个糖都有两个，那妹妹刚好能得到所有种类，数量跟第一种一样。 最小极端情况，就一种糖，那妹妹就只能得到一种。
	public static int distributeCandies(int[] candies) {
		//这一题想要快的关键在于，要给set指定初始化大小、和负载因子。避免扩容造成时间浪费
		Set<Integer> set = new HashSet<>(candies.length, 2);
		for(int i = 0; i < candies.length; i++) {
			set.add(candies[i]);
		}
		return Math.min(set.size(), candies.length / 2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 2, 3};
		System.out.println(distributeCandies(nums));
	}

}
