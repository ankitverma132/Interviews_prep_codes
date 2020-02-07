import java.util.ArrayList;
public class BinaryInDecimal {
	public static void main(String[] args)
	{
		System.out.println(countOfNumbers(100));				
	}

	public static int countOfNumbers(int n)
	{    
		ArrayList<Integer> A=new ArrayList<Integer>();
		
        int Count=0;
        for(int i=1; i<=n ; i++)
        {   
        	
           int temp=i;
           while( temp>0 )
           {
              int b = temp%10;
              A.add(b);
              temp = temp/10;
           }  

           int L=0;
           for(int j=0;j<A.size();j++)
           {
               if(A.get(j)==1 || A.get(j)==0)
               {
                L++;   
               }
           }
           if(L==A.size())
           {
               Count++;
           }
           A.clear();
        }
        return Count;                    
     }
}