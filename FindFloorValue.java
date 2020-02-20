package Recursion;
public class FindFloorValue {

	public static void main(String[] args) {

		int[] A = {10, 20, 30, 40, 50};
		int n = 25;
		System.out.println( findFloor( A, n ) );
	}
	
    public static int findFloor(int[] array, int element){
		
        return helper(array, element, 0);
		
	}
    
    public static int helper(int[] array, int element, int i){
        
        if( i == array.length ){
            return 0;
        }
        
        int smallAns = helper(array, element, i+1);
        
        if( array[i] < element && array[i] > smallAns){
            return array[i];
            
        }
        else{
            return smallAns;
        }

    }
    
}