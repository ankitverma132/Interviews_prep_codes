package TimeSpaceComplexity;
import java.util.Arrays;

public class PrinArrayIntersection {
	public static void main(String[] args) {
		
	     int[] arr1 = {2, 6, 1, 2};
	     int[] arr2 = {1, 2, 3, 4, 2};
	     intersection( arr1, arr2 );
		}
	
	public static void intersection(int[] arr1, int[] arr2){
		
//      for(int i=0; i<arr1.length; i++)
          
//       {
//          for(int j=0; j<arr2.length;j++)
//             {     
//               if(arr1[i]==arr2[j])
//                 {
//                   System.out.println(arr1[i]);
//                   arr2[j]=-1;
//                   break;
//                  // if(i==arr1.length-1)
//                  //  {                                   
//                  //    break;
//                  //  }
//                  //   i++;
//                  //   j=0;
//                  //   continue;                 
//                  }
//              }           
//         }
     Arrays.sort(arr1);       // time complexity  O(nlogn)+O(mlogm)+O(m++n)    space complexity O(1)
     Arrays.sort(arr2);
     
     int i=0,j=0;
     while(i<arr1.length && j<arr2.length){
         if(arr1[i]==arr2[j]){
             System.out.println(arr1[i]);
             i++;
             j++;
         }
         else if(arr1[i]>arr2[j]){
             j++;
         }
         else{
             i++;
         }
     }
   }
}