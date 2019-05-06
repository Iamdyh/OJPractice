package com.dyh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Self Dividing Numbers：自除数，可以整除每一位上的数，不包含除数为0的数。现在给定一个范围，求这个范围内的自除数
 * 128是自除数，因为:128%1 = 0, 128%2 = 0, 128%8 = 0。
 * 例：left = 1, right = 22
 * 返回： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * @author dyh
 *
 */

public class SelfDividingNumbers {

	public static List<Integer> selfDividingNumbers(int left, int right) {
        if(left == 0 || right == 0) {
        	return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        boolean res;
        
        for(int i = left; i <= right; i++) {
        	res = isSelfNumbers(i);
        	if(res) {
        		list.add(i);
        	}
        }
        return list;
    }
	
	public static boolean isSelfNumbers(int num) {
		if(num < 10) {
			return true;
		}
		int temp = num;
		int a = 0;
		int b = 0;
		while(temp > 0) {
			a = temp / 10;
			b = temp % 10;
			if(b == 0) {
				return false;
			}
			if(num % b == 0) {
				temp = a;
				continue;
			}else {
				return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int left = 1;
		int right = 22;
		List<Integer> res = new ArrayList<>();
		res = selfDividingNumbers(left, right);
		for(int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
