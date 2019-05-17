package com.dyh.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Subdomain Visit Count:A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 *	例：["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
   *     返回：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]：We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * @author dyh
 *
 */
public class SubdomainVisitCount {

	//我们可以利用哈希表来存储每个网址的访问次数，按要求遍历字符串数组，对每个字符串利用空格划分访问次数及网址；每个网址中包含一个或者两个‘.’，我们可以利用’.'来找出所有的子域名
	public static List<String> subdomainVisits(String[] cpdomains) {
		List<String>  list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String string: cpdomains) {
			int count = Integer.valueOf(string.substring(0, string.indexOf(" ")));
			String domains = string.substring(string.indexOf(" ")+ 1);
			int dot = 0;
			while(dot != -1) {
				String domain = dot == 0 ? domains.substring(dot):domains.substring(++dot);
				map.put(domain, map.getOrDefault(domain, 0) + count);
				dot = domains.indexOf('.', dot);
			}
			
		}
		
		for(String domain: map.keySet()) {
			list.add(map.get(domain) + " " + domain);
		}
		return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"9001 discuss.leetcode.com"};
		List<String> list = subdomainVisits(strings);
		for(String string: list) {
			System.out.println(string);
		}
	}

}
