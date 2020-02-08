//Count platforms
//Send Feedback
//Given two arrays (both of size n), one containing arrival time
//of trains and other containing the corresponding trains departure 
//time (in the form of an integer) respectively. Return the minimum 
//number of platform required, such that no train waits.
//Arrival and departure time of a train can't be same

import java.util.Arrays;
public class Solution {
	public static void main(){
		
		int arrival[] = {1100, 1101 ,1103,1105};
		int departure[] = {1110, 1102, 1104, 1106};
		
		 Arrays.sort(arrival); 
         Arrays.sort(departure); 
        
   // plat_needed indicates number of platforms 
   // needed at a time 
   int plat_needed = 1, result = 1; 
   int i = 1, j = 0; 
   int n = arrival.length;
   // Similar to merge in merge sort to process  
   // all events in sorted order 
   while (i < n && j < n) 
   { 
      // If next event in sorted order is arrival,  
      // increment count of platforms needed 
      if (arrival[i] <= departure[j]) 
      { 
          plat_needed++; 
          i++; 
   
          // Update result if needed  
          if (plat_needed > result)  
              result = plat_needed; 
      } 
   
      // Else decrement count of platforms needed 
      else
      { 
          plat_needed--; 
          j++; 
      } 
   } 
   
   System.out.print(result); 
 
    }	
}