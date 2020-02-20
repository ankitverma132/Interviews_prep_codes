package Recursion;
public class FindIndex {

	 public static void main(String[] args) {
     
		int input[] = {9, 8, 10, 8};
		int x= 8;
		
		System.out.print(firstIndex(input, x));
		
	}
	
      public static int firstIndex(int input[], int x) {
        
        return (firstIndexBetter(input, x, 0));
		
	}

	 private static int firstIndexBetter(int[] input, int x, int start) {

		 
		 if( input[start] == x ) {
			 return start;
		 }
		 if(start >= input.length-1) {
			 return -1;
		 }
		 		
		int smallAns = firstIndexBetter(input, x, start+1);
		return smallAns;
		
		
	}

}
