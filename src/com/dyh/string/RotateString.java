package com.dyh.string;

/**
 * Rotate String:We are given two strings, A and B.A shift on A consists of taking string A and moving the leftmost character to the rightmost position. 
 * For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 * 例：A='abcde', B='cdeab'
 * 返回：true
 * 思路：String new = A + A，如果new中包含B，那么符合题意，返回true.
 * @author dyh
 *
 */

public class RotateString {
	
	public static boolean rotateString(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		if(lenA != lenB) {
			return false;
		}
		String strNew = A + A;
		if(strNew.contains(B)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
