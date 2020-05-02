//Find the smallest window in a string containing all characters of another string
//Given two strings string1 and string2,
//the task is to find the smallest substring in string1 containing
//all characters of string2 efficiently.
//
//Examples:
//Input: string = “this is a test string”, pattern = “tist”
//Output: Minimum window is “t stri”
//Explanation: “t stri” contains all the characters of pattern.
//
//Input: string = “geeksforgeeks”, pattern = “ork”
//Output: Minimum window is “ksfor”
package Maps;
import java.util.HashMap;

public class smallestWindowContainingAnotherString {
	
	private static String findSubString(String str, String pat) {
		

        int len1 = str.length(); 
        int len2 = pat.length(); 
      
        // check if string's length is less than pattern's 
        // length. If yes then no such window can exist 
        if (len1 < len2) 
        { 
            System.out.println("No such window exists"); 
            return ""; 
        } 
      
        int hash_pat[] = new int[256]; 
        int hash_str[] = new int[256]; 
      
        // store occurrence ofs characters of pattern 
        for (int i = 0; i < len2; i++) {
            hash_pat[pat.charAt(i)]++; 
        }
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE; 
      
        // start traversing the string 
        int count = 0; // count of characters 
        for (int j = 0; j < len1 ; j++) 
        { 
            // count occurrence of characters of string 
            hash_str[str.charAt(j)]++; 
      
            // If string's char matches with pattern's char 
            // then increment count 
            if (hash_pat[str.charAt(j)] != 0 && 
                hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)] ) {
                count++; 
            }
      
            // if all the characters are matched 
            if (count == len2) 
            { 
                // Try to minimize the window i.e., check if 
                // any character is occurring more no. of times 
                // than its occurrence in pattern, if yes 
                // then remove it from starting and also remove 
                // the useless characters. 
                while ( hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] 
                    || hash_pat[str.charAt(start)] == 0) 
                { 
      
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) 
                        hash_str[str.charAt(start)]--; 
                    start++; 
                } 
      
                // update window size 
                int len_window = j - start + 1; 
                if (min_len > len_window) 
                { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
      
        // If no window found 
        if (start_index == -1) 
        { 
        System.out.println("No such window exists"); 
        return ""; 
        } 
      
        // Return substring starting from start_index 
        // and length min_len 
        return str.substring(start_index, start_index + min_len); 
        
        
        
//		if( str.length() < pat.length() ) {
//			System.out.println( "Not exists" );
//			return "";
//		}
//		HashMap< Character, Integer > mapP = new HashMap<>();
//		for( int i = 0; i < pat.length(); i++ ) {
//			if( mapP.containsKey(pat.charAt(i))) {
//				mapP.put(pat.charAt(i), mapP.get(pat.charAt(i)) + 1);
//			}
//			else {
//				mapP.put(pat.charAt(i), 1);
//			}
//		}
//		int count = 0;
//		int start = 0;
//		int start_index = -1;
//		int min_len = Integer.MAX_VALUE;
//		HashMap< Character, Integer > mapS = new HashMap<>();
//		for( int i = 0; i < str.length(); i++ ) {
//			if( mapS.containsKey(str.charAt(i))) {
//				mapS.put(str.charAt(i), mapS.get(str.charAt(i)) + 1);
//			}
//			else {
//				mapS.put(str.charAt(i), 1);
//			}
//			
//			if( mapP.containsKey(str.charAt(i)) 
//					&& mapS.get(str.charAt(i)) <= mapP.get(str.charAt(i))) {
//				count++;
//			}
//			if( count == pat.length() ) {
//				//yha hashmap use krne se ye issue aaega ki jo ki mapP hashmap 
//				//main nhi h unki b value access krne ka try hoga for comoparision
//				//like when start = 1, h key k liye value dhundega jo ki  null
//				//milega
//				while( !mapP.containsKey(str.charAt(start))
//						|| mapS.get(str.charAt(start)) > mapP.get(str.charAt(start))
//						  ) {
//					
//				if( mapP.containsKey(str.charAt(start)) && 
//						mapS.get(str.charAt(start)) > mapP.get(str.charAt(start)) ) {
//						mapS.put(str.charAt(str.charAt(start)), 
//					    mapS.get(str.charAt(start)) - 1);
//					}
//					start++;
//					
//				}
//				int len_window = i - start + 1;
//				if (min_len > len_window) 
//                { 
//                    min_len = len_window; 
//                    start_index = start; 
//                    //System.out.println( start_index);
//                } 
//			}
//		}
//		 // If no window found 
//        if (start_index == -1) 
//        { 
//        System.out.println("No such window exists"); 
//        return ""; 
//        } 
//        // Return substring starting from start_index 
//        // and length min_len 
//        return str.substring(start_index, start_index + min_len);
		
	}
	
	public static void main(String[] args) {
		String str = "this is a test string"; 
        String pat = "tist"; 
      
        System.out.print("Smallest window is :\n " + 
                        findSubString(str, pat)); 
	}
}