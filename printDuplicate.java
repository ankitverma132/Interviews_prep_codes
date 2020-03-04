package TimeSpaceComplexity;

import java.util.Arrays;

public class printDuplicate {

	public static void main(String[] args) {
		
       int[] A = {0, 7, 2, 5, 4, 7, 1, 3, 6};
       System.out.println( duplicate(A) );
	}
	
	public static int duplicate(int[] arr){
		
		Arrays.sort(arr);                     // time Complexity O(nlogn)+O(n)    space compexity O(1)
		for(int i =1; i<arr.length; i++) {
			if(arr[i]==arr[i-1]) {
				return arr[i];
			}
		}
		return -1;
		
//		    int Sum = 0;
//		    for(int i=0; i<arr.length; i++){              // time Complexity O(n)   space compleity o(1)
//		        Sum = Sum + arr[i];
//		        }         
//		    return  Sum - new_sum(arr.length-1);
//			 }
//		    
//		     public static int new_sum(int n){
//		        
//		        return ( n*(n-1) )/2;           
//		    }
//
	}
}
