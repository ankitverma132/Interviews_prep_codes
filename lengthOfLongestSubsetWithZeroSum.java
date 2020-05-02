//Send Feedback
//Given an array consisting of positive and negative integers, 
//find the length of the longest subarray whose sum is zero.
//Sample Input :
//10 
// 95 -97 -387 -435 -5 -70 897 127 23 284
//Sample Output :
//5
package Maps;
import java.util.ArrayList;
import java.util.HashMap;

public class lengthOfLongestSubsetWithZeroSum {
	
	public static int lengthOfLongestSubsetWithZeroSum( ArrayList<Integer> arr) {
		
		int maxLen = 0;
		int sum = 0;
		HashMap< Integer, Integer > map = new HashMap<>();
		for( int i = 0; i < arr.size(); i++ ) {
			sum = sum + arr.get(i);
			if( sum == 0 ) {				
				maxLen = i + 1;
                map.put(sum, i);
			}
			else {
				if( map.containsKey(sum)) {
					if( maxLen < i - map.get(sum)) {
						maxLen = i - map.get(sum);
					}                   
                }
                else{
                	 map.put(sum, i);
                }
			}
		}
		return maxLen;
		//brute force method
		//time complexity - O(n^2)
//		 int max_len = 0; 
//	        // Pick a starting point 
//	        for (int i = 0; i < arr.size(); i++) { 
//	            // Initialize curr_sum for every starting point  
//	            int curr_sum = 0; 
//	  
//	            // try all subarrays starting with 'i' 
//	            for (int j = i; j < arr.size(); j++) { 
//	                curr_sum += arr.get(i); 
//	  
//	                // If curr_sum becomes 0, then update max_len 
//	                if (curr_sum == 0) {
//	                    max_len = Math.max(max_len, j - i + 1); 
//	                }
//	            } 
//	        } 
//	        return max_len; 
	}
	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(6);
		al.add(1);
		al.add(5);
		al.add(-8);
		al.add(-4);
		al.add(2);
		System.out.println(lengthOfLongestSubsetWithZeroSum( al )); 

	}
}