package Recursion;
public class countInversion {

	public static void main(String[] args) {
		
		int[] A = {2, 5, 1, 3, 4};
		int n = 5;
		System.out.println(solve(A, n));

	}
	
	public static long solve(int[] A,int n){

        return helper(A, n, 0);
    }
		
		
    private static long helper(int[] A,int n, int i){  
        
        if(i == n-1){
            return 0;
        }

        long smallAns = helper(A, n, i+1);
        
        int count = 0;        
        for( int j = i+1; j<n; j++){
            if (A[i] > A[j] ){
                count++;
                
            }
        }
        smallAns = smallAns+ count;
        return smallAns;
        
    }  
}