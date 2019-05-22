package com.dyh.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Last Stone Weight：Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * 例：[2,7,4,1,8,1]
 * 返回：1
 * @author dyh
 *
 */

public class LastStoneWeight {
	
	//利用优先队列的特性可以解决该题
	public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i: stones) {
        	queue.offer(i);
        }
        while(queue.size() > 1) {
        	queue.offer(queue.poll() - queue.poll());
        }
        return queue.peek();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 7, 4, 1, 8, 1};
		System.out.println(lastStoneWeight(stones));
	}

}
