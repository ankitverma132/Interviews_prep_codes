package Recursion;

public class PrintIncreasing {

	public static void main(String[] args) {
		
		int n = 6;
	    print(6);
		
	}
		public static void print(int n){
			if(n == 1){
				System.out.print(n + " ");
				return;
			}
			print(n - 1);
			System.out.print(n+" ");
			
		}

	
}
