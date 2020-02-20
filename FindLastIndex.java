package Recursion;
public class FindLastIndex {

	 public static void main(String[] args) {
     
		int input[] = {9, 8, 10, 8};
		int x= 8;
		
		System.out.print(firstIndex(input, x));
		
	}
	
      public static int firstIndex(int input[], int x) {
        
        return (firstIndexBetter( input, x, input.length-1 ));
		
	}

	 private static int firstIndexBetter(int[] input, int x, int end) {

		 
		 if( input[end] == x ) {
			 return end;
		 }
		 if(end <= 0) {
			 return -1;
		 }
		 		
		int smallAns = firstIndexBetter(input, x, end-1);
		return smallAns;
		
		
	}

}
