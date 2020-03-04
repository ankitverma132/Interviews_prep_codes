package TimeSpaceComplexity;

import java.util.Arrays;

public class pairSum {

	public static void main(String[] args) {

		int[] arr = { 1 ,3 ,6 ,2 ,5 ,4 ,3 ,2 ,4 };
		int num = 7;
		pairSum( arr, num );
	}
	public static void pairSum(int[] arr, int num){
		
//        for(int i=0;i<arr.length-1;i++)
//        {
//            for(int j=i+1;j<arr.length;j++)
//            {
//                int Sum=arr[i]+arr[j];         // time complexity (n^2)   space complexity 1     
//                if(Sum==num)
//                  {
//                     if(arr[i]<arr[j])
//                     System.out.println( arr[i] + " " + arr[j] );
//                     else
//                     System.out.println( arr[j] + " " + arr[i] );
//                   }    
//              }
//         }	
//
        Arrays.sort(arr);             // time complexity O(n) to O(n^2)  space complexity O(1)
        int i = 0;
		int j = arr.length-1;
		while(i<j) {
			
			if( arr[i]==arr[j] && arr[i]+arr[j] == num )
			{			     
                 int m = nCr( j-i+1 );
                 for(int l = 0; l<m; l++){
                    System.out.println( arr[i] + " " + arr[j] );
                }
                break;			
			}
            
			else if( arr[i]+arr[j] == num && arr[i]!=arr[j] )
			{
				int count1 = 1;
				for( int m = i+1; m < j; m++ ) {
					if(arr[m] == arr[i]) {
						count1++;
					}
				}
				int count2 = 1;
				for( int m = j-1; m > i; m-- ) {
					if(arr[m] == arr[j]) {
						count2++;
					}
				}
				int count = count1*count2;
				for( int m = 0; m < count; m++ ) {
					System.out.println( arr[i] + " " + arr[j] );
				}
                i = i + count1;
				j = j - count2;
			}
			else if( arr[i]+arr[j] < num )
			{
				i++;
				
			}
			else
			{
				j--;
			}	
		}
	}
    public static int nCr(int n){
        
        return (fact(n))/(fact(n-2)*2);
        
    }
    public static int fact(int q){
       if(q==0){
           return 1;
       } 
        return q*fact(q-1);
    }
}