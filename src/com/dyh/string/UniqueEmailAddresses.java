package com.dyh.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 * 例：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 返回：2
 * "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 * @author dyh
 *
 */

public class UniqueEmailAddresses {
	
	public static int numUniqueEmails(String[] emails) {
	     Set<String> uniqueEmailList = new HashSet<>();
	     for(String string: emails){
	    	 String[] temp = string.split("@");        
	    	 StringBuilder sb = new StringBuilder();
	    	 for(int i = 0; i < temp[0].length(); i++){
	    		 char c = temp[0].charAt(i);
	    		 if(c == '+'){
	    			 break;                 				//如果遇到'+', 直接退出循环
	    		 }
	    		 if(c != '.'){
	    			 sb.append(c);                          //如果不是'.', 重组email的localName
	    		 }
	    	 }
	    	 
	    	 uniqueEmailList.add(sb.append("@").append(temp[1]).toString());
	     }
		 return uniqueEmailList.size();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
	}

}
