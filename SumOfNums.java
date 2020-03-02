package Recursion;

public class SumOfNums {

	public static void main(String[] args) {
		
		int n=4;
		System.out.println(Sum(n));

	}

	private static int Sum(int n) {
		
		if(n==1) {    // Base Case
			return 1;
		}
		
		return n + Sum(n-1);   //Smaller Problem and final calculation
	
	}

}
