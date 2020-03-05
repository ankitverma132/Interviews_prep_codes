package Recursion;
import java.util.Arrays;
public class MaxProfitApp {

	public static void main(String[] args) {
     int[] A = { 14 ,20 ,30 ,53 };
     System.out.println(maximumProfit( A ));
		
	}

	public static int maximumProfit(int budget[]) {
			
	        Arrays.sort(budget);  // O(nlogn) + O(n)
	        
	        int max = Integer.MIN_VALUE;
	        
	        for( int i = 0; i<budget.length; i++ ){
	            int value = budget[i]*(budget.length-i);
	            if(value>max){
	                max = value;
	            }            
	        }  
	        return max;
	}	
}