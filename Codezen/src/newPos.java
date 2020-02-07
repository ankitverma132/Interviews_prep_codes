//You are given two integers n and k.
//Assume numbers from 1 to n are arranged in a way that - 
//all odd numbers (in ascending order) comes first 
//and then comes all even numbers (also in ascending order).
//You need to find and return the integer
//which is at position k (numbering of positions start from 1).

import java.util.ArrayList;
public class newPos {

	public static void main(String[] args) {
		int n=7;
		int k=3;
				
		ArrayList<Long> A = new ArrayList<>();
		        
		   for(long i=1; i<=n; i++){
		       if(i%2!=0){
		         A.add(i);
		        } 
		    }
		   for(long i=1; i<=n; i++){
		       if(i%2==0){
		         A.add(i);
		         }
		    }
		      
		 System.out.print(A.get(k-1));
	}
}