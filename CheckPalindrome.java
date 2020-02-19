package Recursion;
public class CheckPalindrome {

	public static void main(String[] args) {

    	String s = "racecar";
       System.out.println( isStringPalindrome(s) );		
	}
	
	public static boolean isStringPalindrome(String input) {

       return isStringPalindrome2(input, 0, input.length()-1);
           
	}
	private static boolean isStringPalindrome2(String input, int i, int j) {

		if(i==j || j-i==1) {
			
			if(input.charAt(i)==input.charAt(j)) {
				return true;
			}
			else {
				return false;
			}
		}
				
		boolean smallAns = isStringPalindrome2(input, i+1, j-1);
		if(!smallAns){
			return false;
		}
		if(input.charAt(i)==input.charAt(j)) {
			return true;
		}
		else {
			return false;
		}		
	}
}