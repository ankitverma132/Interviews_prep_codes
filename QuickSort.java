package Recursion;
public class QuickSort {

	public static void main(String[] args) {
		int A[] = {3,3,7,0,8,5};
		quickSort(A);
		for(int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	public static void quickSort(int[] A) {
		helper(A, 0, A.length-1);
	}

	private static void helper(int[] A, int si, int ei) {
		if(si>=ei) {
			return;
		}
		int pivot_pos = partiton(A, si, ei);
		helper(A, si, pivot_pos-1);
		helper(A, pivot_pos+1, ei);
		
		
	}

	private static int partiton(int[] A, int si, int ei) {
		int pivot = A[si];
		
		int count = 0;
		for(int i = si+1; i<=ei; i++) {
			if( pivot>=A[i] ){
				count++;
			}
		}
		int pivotPos = si + count;
		
		int temp = A[si];
		A[si] = A[pivotPos];
		A[pivotPos] = temp;
		
		
		 int i = si, j = ei;
		   while( i<pivotPos && j>pivotPos) {
	             if( A[i]<=pivot) {
					 
				   i++;
			   }
	            else  if( A[j] > pivot) {
				 
				   j--;
			   }
			 
			   else  {
				   //swap
				   int temp2 = A[i];
				   A[i] = A[j];
				   A[j] = temp2;
				   i++;
				   j--;
				   
			   }
			  	  
		   }
			return pivotPos;
	}
}