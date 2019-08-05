package com.dyh.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fizz Buzz: Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * input: 15
 * output:["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz""]
 * @author dyh
 *
 */

public class FizzBuzz {
	
	public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
        	if(i % 3 == 0 && i % 5 == 0) {
        		list.add("FizzBuzz");
        	}else if(i % 3 == 0) {
        		list.add("Fizz");
        	}else if(i % 5 == 0) {
        		list.add("Buzz");
        	}else {
        		list.add(i+"");
        	}
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		System.out.println(fizzBuzz(n).toString());
	}

}
