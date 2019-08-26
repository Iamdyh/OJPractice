package com.dyh.string;

/**
 * Design HashMap
 * @author dyh
 *
 */

public class MyHashMap {
	
	Integer[] values;
	public MyHashMap() {
		values = new Integer[1000001];
	}
	
	public void put(int key, int value) {
		values[key] = value;
	}
	
	public int get(int key) {
		if(values[key] == null) {
			return -1;
		}
		return values[key];
	}
	
	public void remove(int key) {
		values[key] = null;
	} 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
