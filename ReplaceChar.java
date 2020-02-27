package Recursion;

public class ReplaceChar {

	public static void main(String[] args) {

		String s = "abcada";
		char c1 = 'a';
		char c2 = 'x';
		System.out.println( replaceCharacter(s, c1, c2) );
		
	}
	
	public static String replaceCharacter(String input, char c1, char c2) {
        
	       // return helper( input, c1, c2, 0);
			 if( input.length() == 0 ){
	            
	            return input;
	        }
	 
	        String ans = "";
	        if( input.charAt(0)==c1 ){
	            
	           ans = ans + c2 ;
	        } 
	        else{
	            
	            ans = ans + input.charAt(0);
	        }
	        
	        String smallAns = replaceCharacter( input.substring(1), c1, c2 );
	        
	        return ans + smallAns;        
	            
	        
		}
	    
//	     public static String helper( String input, char c1, char c2, int i ) {
	        
//	         if( i==input.length() ){
//	             return "";
	            
//	         }
	 
//	         String smallAns = helper(  input,  c1,  c2,  i+1 );
	        
//	         if( input.charAt(i) == c1 ){
	            
//	             return c2 + smallAns;
	            
//	         }
//	         else{
	            
//	             return input.charAt(i) + smallAns;
	             
//	        }
	          
//	     }   

}
