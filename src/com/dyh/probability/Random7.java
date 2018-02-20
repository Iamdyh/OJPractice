package com.dyh.probability;

import java.util.Random;

/**
 * 随机函数练习题 :给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制，请实现等概率随机产生1~7的随机函数。(给定一个可调用的Random5::random()方法,可以等概率地随机产生1～5的随机函数)
 * 思路：这道题本质就是得到一串均匀分布且长度大于7的连续序列即可（甚至都不需要连续，只要保证能产生7个以上等概率的数即可），在这个序列里选中7个（或7的倍数个），若得到的数不是这7个中的，重新产生。这样这7个数的概率肯定是相同的。
 * 举例int num = 5 * rand5() + rand5();      
 * //生成6~25的数，选取其中7~20这14个数，非这14个数重新生成，最后取余即可
 * @author dyh
 *
 */

public class Random7 {
	
	private static Random rand = new Random(123456);
	// 随机产生[1,5]
	private static int rand5() {
		return 1 + rand.nextInt(5);
	}
	// 通过rand5实现rand7
	public static int randomNumber() {
		//通过rand5函数随机产生[1,7]
        int a = (rand5() - 1) * 5 + rand5();
        while (a > 21) {
            a = (rand5() - 1) * 5 + rand5();
        }

		return a % 7 + 1;
	}

	

}
