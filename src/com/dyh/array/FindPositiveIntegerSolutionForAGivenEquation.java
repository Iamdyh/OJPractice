package com.dyh.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Find Positive Integer Solution for a Given Equation:Given a function  f(x, y) and a value z, return all positive integer pairs x and y where f(x,y) == z.
 * The function is constantly increasing, i.e.:
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * For custom testing purposes you're given an integer function_id and a target z as input, where function_id represent one 
 * function from an secret internal list, on the examples you'll know only two functions from the list. 
 * You may return the solutions in any order.
 * Input: function_id = 1, z = 5
 * Output: [[1,4],[2,3],[3,2],[4,1]]
 * Explanation: function_id = 1 means that f(x, y) = x + y
 * @author dyh
 *
 */
interface CustomFunction {
	int f(int x, int y);
}

public class FindPositiveIntegerSolutionForAGivenEquation {

	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		int start = 1;
		int end = 1000;
		while(start <= 1000 && end >= 1) {
			int r = customfunction.f(start, end);
			if(r == z) {
				List<Integer> temp = new LinkedList<>();
				temp.add(start);
				temp.add(end);
				list.add(temp);
				start ++;
				end --;
			}else if(r > z) {
				end --;
			}else {
				start++;
			}
		}
        return list;
    }
	
}
