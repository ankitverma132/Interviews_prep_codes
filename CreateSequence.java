//Given an integer n, you need to print all numbers
//less than n which are having digits only 2 or 5 or both.

package Recursion;
public class CreateSequence {

	public static void main(String[] args) {

        int n = 1000;
        Create(n);	
	}

	private static void Create(int n) {		
		
		if(n==1) {
			return;
		}		
		
		Create(n-1);
		
		int temp = n;
		boolean flag = true;
		while( temp > 0 ) {			

			int a = temp%10;
			if(a!=2 && a!=5) {
				//System.out.println(a);
				flag = false;
			}
			temp = temp/10;
		}
		if(flag == true) {
			System.out.println(n);
		}			
	}
}