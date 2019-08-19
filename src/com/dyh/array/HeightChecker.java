package com.dyh.array;

import java.util.Arrays;

/**
 * Height Checker:Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students not standing in the right positions.  
 * (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * input:[1,1,4,2,1,3]
 * output:3
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * @author dyh
 *
 */

public class HeightChecker {

	public static int heightChecker(int[] heights) {
        int count = 0;
        int[] temp = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
        	temp[i] = heights[i];
        }
        Arrays.sort(temp);
        for(int i = 0; i < heights.length; i++) {
        	if(temp[i] != heights[i]) {
        		count ++;
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1, 1, 4, 2, 1, 3};
		System.out.println(heightChecker(heights));
	}

}
