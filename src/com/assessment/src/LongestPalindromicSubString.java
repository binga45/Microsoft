package com.assessment.src;

/*
 * Finds the longest palindromic substring
 */
public class LongestPalindromicSubString {


	public static void main(String[] args){
		String s = "caabbd";

		PalindromicSubString ps = new PalindromicSubString();
		System.out.println(ps.computeBestPalindrome(s.length(), s));
	}
}

