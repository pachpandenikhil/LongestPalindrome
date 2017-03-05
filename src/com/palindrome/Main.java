package com.palindrome;

public class Main {
	
	public int longestPalindrome(String s) {
        int[] characters = new int[52];
        int length = 0;
        //collecting character counts
        for (int i = 0; i < s.length(); i++) {
        	char currChar = s.charAt(i);
			if(Character.isLowerCase(currChar)) {
				characters[currChar - 'a']++;
				
			}
			else {
				characters[currChar - 'A' + 25]++;
			}
		}
        
        //adding even lengths to count and adding odd_length - 1 to count
        boolean odd_length_present = false;
        for (int i = 0; i < characters.length; i++) {
			int count = characters[i];
			if( (count != 0) && (count % 2 == 0) ) {
				length += count;
			}
			else if( (count != 0) && (count % 2 == 1) ) {
				odd_length_present = true;
				length += count - 1;
			}
		}
        
        if(odd_length_present) {
        	length += 1;
        }
        
        return length;
    }

	public static void main(String[] args) {
		Main obj = new Main();
		//String s = "AAAaabbccccdde";
		//String s = "aaaAaaaa";
		String s = "abccccdd";
		System.out.println(obj.longestPalindrome(s));
	}

}
