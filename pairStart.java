//Given a string, compute recursively a new string
//where identical chars that are adjacent in the original string 
//are separated from each other by a "*".

package Recursion;
public class pairStart {

	public static void main(String[] args) {
		
		String s = "xxyy";
		System.out.println(addStars(s));

	}
   public static String addStars(String s) {
		
        return helper(s, 0, 1);
	}
    public static String helper(String s, int i, int j){
        
        if( i == s.length()-1){
            return Character.toString(s.charAt(i));
        }
        
        String smallAns = helper(s, i+1, j+1);
        
        if( s.charAt(i) == s.charAt(j)){
            String Ans = Character.toString(s.charAt(i)) + "*" + smallAns;
            return Ans;
            
        }
        else {
            String Ans = Character.toString(s.charAt(i)) + smallAns;
            return Ans;
        }       
    }
}