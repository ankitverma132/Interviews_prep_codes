package Recursion;
public class ReplacePi {

	public static void main(String[] args) {

		String s = "xpixpix";
		System.out.println(replace(s));
		
	}
    public static String replace(String input){
        
        return helper( input, 0 );
    
	}
    public static String helper(String input, int i){
        
        if( i == input.length() ){
            return "";
        }       
 
        String smallAns = helper(input, i+1);
        
        if( input.charAt(i)!='p' ){
            String Ans = input.charAt(i) + smallAns;
            return Ans;
        }
        else {
            if( i<input.length()-1 && input.charAt(i+1) == 'i' ){
               String Ans = "3.14" + smallAns.substring(1,smallAns.length());
                return Ans;
            }
            else{
                String Ans = input.charAt(i) + smallAns; 
                return Ans;
            }   
        }   
    }
}