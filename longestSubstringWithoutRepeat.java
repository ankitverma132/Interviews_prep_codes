//Level MEDIUM
//You are given a string S that may or may not contain repeating characters.
//Your task is to find out the length of the longest substring
//of this given string that does not contain any repeating characters.
//NOTE : You have to return the length.No need of printing it.
//Input Format :
//String S
//Output Format :
//Length of required substring
//Sample Input :
//ibnoffjytr
//Sample Output :
//5

package Maps;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeat {
	
	public static int longestSubstringLength(String s) {

		 if( s == null || s.length() == 0 ){
	        return 0;
	    }
	 
	    HashSet<Character> set = new HashSet<>();
	    int result = 1;
	    int i = 0;  
	    for( int j = 0; j < s.length(); j++ ){
	        char c = s.charAt(j);
	        if( !set.contains(c) ){
	            set.add(c);
	            result = Math.max(result, set.size());
	        }
	        else{
	            while( i < j ){
	                if( s.charAt(i) == c ){
	                    i++;
	                    break;
	                }
	                //remove krne se bad k element ko  
	                //repetition nhi show hoga
	                set.remove(s.charAt(i));
	                i++;
	            }
	        }    
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {

		String str = "aab";
		System.out.println( longestSubstringLength( str ) );
	}

}
