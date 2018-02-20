package com.dyh.probability;

import java.util.Random;

/*
 * 随机01练习题:给定一个以p概率产生0，以1-p概率产生1的随机函数RandomP::f()，p是固定的值，但你并不知道是多少。除此之外也不能使用任何额外的随机机制，
 * 请用RandomP::f()实现等概率随机产生0和1的随机函数。
 * 思路：1、产生01和10序列的概率都为P*(1-P)；
 * 2、不断调用f，直到能够产生01或10，序列终止；
 * 3、如果产生了01，返回0；
 * 4、如果产生了10， 返回1。
 */

public class Random01 {
	private static double p = new Random().nextFloat();
	// 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }
    public int random01() {
        // 通过f函数实现01等概率返回
    	int a = f()*10 + f();
    	while(a == 00 || a == 11) {
    		a = f() * 10 + f();
    	}
    	if(a == 01)
    		return 1;
    	else
    		return 0;
    }

}
