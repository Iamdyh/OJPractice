package com.dyh.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Groups of Special-Equivalent Strings:你将得到一个字符串数组 A。如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
 *  一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
 *  现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
 *  返回 A 中特殊等价字符串组的数量。
 *  input:["a","b","c","a","c","c"]
 *  output:3
 *  explanation:3 组 ["a","a"]，["b"]，["c","c","c"]
 * @author dyh
 *
 */

public class GroupsofSpecialEquivalentStrings {

	/**
	 *  该题的意思是找出整个字符串里面有多少个不同的等价字符串，这个等价定义就是字符串的偶数位可以随便调换位置，奇数位同理。
	 *  那么两个字符串等价要满足
		奇数位对应的字母频数完全相同
		偶数位对应的字母频数完全相同
		那么我们把一个等价组当作一个元素，最后判断有多少个元素即可。
	 */
	
	public static int numSpecialEquivGroups(String[] A) {
       Set<String> set = new HashSet<>();
       for(String string:A) {
    	   int[] odd = new int[26];
    	   int[] even = new int[26];
    	   for(int i = 0; i < string.length(); i++) {
    		   if((i & 1) == 0) {
    			   even[string.charAt(i) - 'a']++;
    		   }else {
    			   odd[string.charAt(i) - 'a'] ++;
    		   }
    	   }
    	   set.add(Arrays.toString(odd) + Arrays.toString(even));
       }
       return set.size();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] aStrings = {"a","b","c","a","c","c"};
		System.out.println(numSpecialEquivGroups(aStrings));
	}

}
