import java.util.Scanner;

public class ArrayIntersection {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int arr[]=new int[N];
		int arr2[]=new int[M];
		
		for(int i=0;i<N;i++)			
		{
		  arr[i]=sc.nextInt();	
		}
		for(int i=0;i<M;i++)			
		{
			arr2[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++)			
		{
		  System.out.print(arr[i] + " ");		  
		}
		System.out.println();
		for(int i=0;i<M;i++)			
		{
		  System.out.print(arr2[i] + " ");
		 
		}
		System.out.println();
		intersections(arr,arr2);

	}
	public static void intersections(int[] input1, int[] input2){       	

		int i=0;
        boolean flag=false;
        while(i<input1.length)
        {
         
            int j=0;
            while(j<input2.length)
            {  
                int a=input1[i];        
                if(a==input2[j])
                  {
                    System.out.println(a);
                    if(i==input1.length-1)
                    {
                        flag=true;
                        break;
                    }
                     i++;
                     j=0;
                     continue;                 
                  }
                j++;
             }
           i++;
          }
        }
    }
