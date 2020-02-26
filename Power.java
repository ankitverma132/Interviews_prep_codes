package Recursion;
public class Power {

	public static void main(String[] args) {
		
		int x=3;
		int n=4;
		System.out.println( Power(x, n) );

	}

	private static int Power(int x, int n) {

	
		if(n==0) {
			return 1;
		}

		return x * Power(x, n-1);
	}

}
