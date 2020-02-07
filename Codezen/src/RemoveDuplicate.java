import java.util.ArrayList;
import java.util.Scanner;
public class RemoveDuplicate {

	public static void removeConsecutiveDuplicates(String s) {
		 Scanner sc = new Scanner(System.in);
         ArrayList<Character> A=new ArrayList<Character>();
         String S = sc.next();      
         
        for(int i=0;i<S.length();i++)
        {
            A.add(S.charAt(i));   
        }  
        int k=A.size();
        for(int i=0;i<k-1;i++)
        {
            if(A.get(i)==A.get(i+1))  
            {
                A.remove(i+1);
                k--;
                i--;
            }
        }
         for(int i=0;i<A.size();i++)
        {
            System.out.print(A.get(i));  
        }   
	}
}