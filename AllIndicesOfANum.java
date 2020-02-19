//Given an array of length N and an integer x, you need to 
//find all the indexes where x is present in the input array. 
//Save all the indexes in an array (in increasing order).

package Recursion;
public class AllIndicesOfANum {

	public static void main(String[] args) {
		int[] arr = {2,6,5,2,3,2};
		int x=2;
		int[] ans = allIndexes(arr,x);
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}

	}
	public static int[] allIndexes(int input[], int x) {
		
    	return (allIndexes2(input, x, 0)); 
}

	public static int[] allIndexes2(int input[], int x, int start) {
        
        if( start==input.length ) {
          return new int[0];
          
        }
        
        int[] smallAns =  allIndexes2(input,  x, start+1); 
        
        if(input[start] != x) {
        	return smallAns;
        }
        else {
        	int[] Ans = new int[smallAns.length+1];
        	Ans[0] = start;
        	for(int i=1; i<Ans.length; i++) {
        		Ans[i] = smallAns[i-1];
        	}
        	
 	    return Ans;
        }
    }
}