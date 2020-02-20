package Recursion;

public class Factorial {

	public static void main(String[] args) {
		
		int n=4;
		System.out.println(fact(n));

	}

	private static int fact(int n) {
		
		if(n==1) {         //Base Case
			return 1;
		}
	
		return n * fact(n-1);  //Smaller problem and final calculation
		
	}

}
