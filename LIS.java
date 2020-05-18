//Longest Increasing Subsequence
//Given an array with N elements, you need to find the length 
//of the longest subsequence of a given sequence such that all 
//elements of the subsequence are sorted in strictly increasing order.
//Sample Input :
//6
//5 4 11 1 16 8
//Sample Output 1 :
//3
//Sample Output Explanation
//Length of longest subsequence is 3 i.e. (5,11,16) or (4,11,16).
//Sample Input 2:
//3
//1 2 2
//Sample Output 2 :
//2
package DP_2;

public class LIS {
	//Using dp
	//Time complexity O(n^2)
	//Brute force complexity would have been O(2^n) 
	//Logic is ki storage array create kro array k corresponding.
	//Har index k corresponding us index tk ki LIS store krte chlo.
	public static int lis(int arr[]) {
		
		int[] storage = new int[arr.length];
		storage[0] = 1;
		if( arr[1] > arr[0] ) {
			storage[1] = 2;
		}
		else {
			storage[1] = 1;
		}
		
		for( int i = 2; i < arr.length; i++ ) {
			int length = 1;
			for( int j = 0; j < i; j++) {
				if( arr[j] < arr[i] && storage[j] >= length ) {
					length = storage[j] + 1;
				}
			}
			storage[i] = length;
		}
		int maxL = Integer.MIN_VALUE;
		for( int i = 0; i < storage.length; i++ ) {
			if( storage[i]  > maxL ) {
				maxL = storage[i];
			}
		}
		return maxL;
	}
	
	public static void main(String[] args) {
		int arr[] = { 5,4,11,1,16,8 };
		System.out.println( lis(arr) );
	}
}