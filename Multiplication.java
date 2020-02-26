package Recursion;
public class Multiplication {

	public static void main(String[] args) {

		int m = 3;
		int n = 5;
		System.out.println(multiplyTwoIntegers(m, n));
		

	}
    
	public static int multiplyTwoIntegers(int m, int n){
		
        if(n==1){
            return m;
        }
        
        return m + multiplyTwoIntegers(m, n-1);        
	
	}

}
