package Recursion;

public class SumOfArray {

	public static void main(String[] args) {
		
		int[] arr = {4, 2, 3};
		System.out.println(Sum(arr));

	}

	private static int Sum(int[] arr) {
		
		
		if( arr.length <= 1) {
			return arr[arr.length-1];
		}
		
		int[] smallArr = new int[arr.length-1];
		for(int i = 1; i<arr.length; i++) {
			
			smallArr[i-1] = arr[i];
		}
		
		int smallAns = Sum(smallArr);
		
		return arr[0] + smallAns;
		
	}

}
