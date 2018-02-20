package com.dyh.probability;

import java.util.Random;

/**
 * 随机区间函数练习题:假设函数f()等概率随机返回一个在[0,1)范围上的浮点数，那么我们知道，在[0,x)区间上的数出现的概率为x(0<x≤1)。
 * 给定一个大于0的整数k，并且可以使用f()函数，请实现一个函数依然返回在[0,1)范围上的数，但是在[0,x)区间上的数出现的概率为x的k次方。
 * 
 * @author dyh
 *
 */

public class RanomSeg {
	private Random rand = new Random(12345);
    public double f() {
        return rand.nextFloat();
    }
    // 请调用f()函数实现
    public double random(int k, double x) {
    	//调用k次f,返回较大的数即可
    	double max = -1;
    	for(int i = 0; i < k; i++) {
    		max = Math.max(max, f());
    	}
        return max;
    }
}
