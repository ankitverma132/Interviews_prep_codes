package Recursion;

public class PrintSubsequences {

	public static void main(String[] args) {
		
        printSubsequences("xyz");
	}
	
	
	public static void printSubsequences(String input) {
		
		printSubsequences(input, "");
	}

	
	public static void printSubsequences(String input, String outputSoFar) {

        if(input.length() == 0) {
        	
        	System.out.println( outputSoFar );
        	return;
        }	
        
        //We choose not to include first character
        printSubsequences(input.substring(1), outputSoFar);
        
        //we choose to include first character
        printSubsequences(input.substring(1), outputSoFar + input.charAt(0));
        	  
	
	}

}