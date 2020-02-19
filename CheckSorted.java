package Recursion;

public class CheckSorted {

	public static void main(String[] args) {

		int[] arr = {4, 2, 3};
		System.out.println(checkSorted(arr));
	}

	private static boolean checkSorted(int[] arr) {
		
		if(arr.length <= 1) {     //Base case
			return true;
		}
		
		int[] SmallArr = new int[arr.length - 1];
		
		for(int i = 1; i<arr.length; i++) {
			SmallArr[i-1] = arr[i];
		}
		
		boolean smallAns = checkSorted(SmallArr);
		
		if(!smallAns) {
			return false;	
		}
		
		if(arr[0]<arr[1]) {
			return true;
		}
		else{
			return false;
		}
//=======================================================================
		
//		if(arr.length <= 1) {     //Base case
//			return true;
//		}
//		
//		if(arr[0]>arr[1]) {
//			return false;
//		}
//		
//		int[] SmallArr = new int[arr.length - 1];
//		
//		for(int i = 1; i<arr.length; i++) {
//			SmallArr[i-1] = arr[i];
//		}
//		
//		boolean smallAns = checkSorted(SmallArr);
//      return smallAns;
		
//=========================================================================
		//Best Apparoch
		
//		private static boolean checkSorted(int[] arr, int startIndex) {
		
//		if(startIndex >= arr.length-1) {     //Base case
//			return true;
//		}
//		
//		if(arr[startIndex]>arr[startInde+1]) {
//			return false;
//		}
//				
//		boolean smallAns = checkSorted(arr, startIndex+1);
//      return smallAns;
		
	}
}