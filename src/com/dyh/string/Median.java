package com.dyh.string;

import java.util.LinkedList;

/**
 * 数据流中的中位数：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author dyh
 *
 */

public class Median {
	
	LinkedList<Integer> list = new LinkedList<>();
	
	public void Insert(Integer num) {
	    if(list.size() == 0 || num < list.getFirst()){
	    	list.addFirst(num);
	    }else{
	    	boolean flag = false;
	    	for (Integer integer : list) {
				if(num < integer){
					int index = list.indexOf(integer);
					list.add(index, num);
					flag = true;
					break;
				}
			}
	    	
	    	if(!flag){
	    		list.addLast(num);
	    	}
	    }
    }

    public Double GetMedian() {
        if(list.size() == 0){
        	return null;
        }
        if(list.size() % 2 == 0){   //如果总数量是偶数
        	
        	int i = list.size() / 2;
        	Double a = Double.valueOf(list.get(i-1) +  list.get(i));
        	return a / 2;
        }
        
//        list.get(0);
        Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        return b;
    }
    
    public static void main(String[] args){
    	Median median = new Median();
    	int[] nums = {9,8,7,10,5,4,3,2,1};
    	for(int i = 0; i < nums.length; i++){
    		median.Insert(nums[i]);
    	}
    	
    	System.out.println(median.GetMedian());
    	
    }

}
