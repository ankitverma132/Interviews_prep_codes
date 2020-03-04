package TimeSpaceComplexity;

import java.util.Arrays;

public class FindUniqueElement {

	public static void main(String[] args) {
		
       int[] arr = {2, 3, 1, 6, 3, 6, 2};
       int ans = findUnique( arr );
	}
	
   public static int findUnique(int[] arr){
	   
//	  Arrays.sort(arr);        // complexity --> O(nlogn)   space complexity O(1)
//	   
//	   for(int i=0; i<arr.length-1; i=i+2) {
//		   
//		   if((i+1)<arr.length && arr[i]!=arr[i+1]) {
//			   return arr[i];
//		   }
//		   else {
//			   return arr[arr.length-1];
//		   }
//	   }
//	   
//	return -1;
	  // time complexity O(n)    space complexity O(1)
	   int ans = arr[0];
	   for(int i=1; i<arr.length; i++) {
		   ans = ans^arr[i];
	   }
		   return ans;
	 }
	
}
