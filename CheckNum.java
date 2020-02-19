package Recursion;

public class CheckNum {

	public static void main(String[] args) {
		
        int x = 1;
		int[] arr = {4, 2, 3};
		System.out.println(Check(arr,x));
	}

	private static boolean Check(int[] arr, int x) {
		
		if(arr[0] == x) {         
			return true;
		}
		if( arr.length <= 1) {      //Base case
			return false;
		}
		
		int[] smallArr = new int[arr.length-1];
		for(int i = 1; i<arr.length; i++) {
			
			smallArr[i-1] = arr[i];
		}
		
		boolean smallAns = Check(smallArr, x);
		
		return smallAns;

	}

}
