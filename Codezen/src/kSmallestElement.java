//k smallest integers in same order
public class kSmallestElement {

	public static void main(String[] args) {
		
		int arr[] = {4, 2, 6, 1, 5};
	    int  k = 3;
	    
		int temp[]= new int[arr.length];
		for(int j=0; j<temp.length; j++) {
			temp[j]=Integer.MIN_VALUE;
			}
		
		int min=Integer.MAX_VALUE;
		int minIndex=0;
		
		for(int i=0; i<k; i++) {
			
			for(int j=0; j<arr.length; j++) {
				
				if(arr[j]<min) {
					min=arr[j];
					minIndex=j;
				}
				temp[minIndex]=min;
			}
		}
	
	   for(int j=0; j<temp.length; j++) {
		   
		 if(temp[j]>Integer.MIN_VALUE) {
			 System.out.print(temp[j] + " ");
		  }
	   }
	   
	}
}