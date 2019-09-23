package com.dyh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Minimum Absolute Difference: Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 * input:arr = [4,2,1,3]
 * output:[[1,2],[2,3],[3,4]]
 * @author dyh
 *
 */

public class MinimumAbsoluteDifference {
	
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> resLists = new ArrayList<List<Integer>>();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < len; i++) {
        	min = Math.min(min, arr[i] - arr[i-1]);
        }
        for(int i = 1; i < len; i++) {
        	if(arr[i] - arr[i - 1] == min) {
        		List<Integer> list = new ArrayList<>();
        		list.add(arr[i-1]);
        		list.add(arr[i]);
        		resLists.add(list);
        	}
        }
        return resLists;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,2,1,3};
		minimumAbsDifference(arr);
	}

}
