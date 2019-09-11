package com.dyh.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Intersection of Two Arrays:Given two arrays, write a function to compute their intersection.
 * input:num1 = [1,2,2,1], num2 = [2,2]
 * output:[2]
 * @author dyh
 *
 */
public class IntersectionOfTwoArrays {

	//O(n^2)
	public static int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 < len2) {
        	return findIntersection(nums1, nums2);
        }else {
        	return findIntersection(nums2, nums1);
        }
    }
	public static int[] findIntersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					set.add(nums1[i]);
					break;
				}
			}
		}
		int[] res = new int[set.size()];
		int count = 0;
		for(Integer value: set) {
			res[count++] = value;
		}
		return res;
	}
	//O(n)
	public static int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for(Integer value : nums1) {
			set.add(value);
		}
		for(Integer value : nums2) {
			if(set.contains(value)) {
				set2.add(value);
			}
		}
		int[] res = new int[set2.size()];
		int count = 0;
		for(Integer value: set2) {
			res[count++] = value;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		System.out.println(Arrays.toString(intersection2(nums1, nums2)));
	}

}
