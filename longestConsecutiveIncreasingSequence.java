package Maps;
import java.util.ArrayList;
import java.util.HashMap;

public class longestConsecutiveIncreasingSequence {

	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr)
    {
        HashMap<Integer,Boolean> map=new HashMap<>();
       
        for( int i = 0; i < arr.length; i++ )
        {
            map.put( arr[i], true );
        }
        int start = 0;
        int longest = 0;
        
        for( int i = 0; i < arr.length; i++ )
        {
            int x = arr[i];
            int temp_length = 0;
            int temp_start = 0;
            if( map.get(x) == true)
            {
                temp_start = x;
                map.put( x, false );
                temp_length = 1;
                x++;
               while( map.containsKey( x ) )
                {
                  map.put(x,false);
                  temp_length++;
                  x++;
                }
                x = arr[i] - 1;
                while( map.containsKey( x ) )
                {
                     temp_start = x;
                     temp_length++;
                     x--;
                }
            }
            if( temp_length > longest ) 
            {
                longest = temp_length;
                start = temp_start;
            }
            if( temp_length == longest )
            {
                int index_temp_start = 0;
                while( arr[index_temp_start] != temp_start )
                {
                    index_temp_start++;
                }
                int index_start = 0;
                while( arr[index_start] != start )
                {
                    index_start++;
                }
                if( index_temp_start < index_start)
                {
                    start = temp_start;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for( int i = start; i < start + longest ; i++ ) 
        {
            list.add( i );
        }
        return list;
    }
      
	public static void main(String[] args) {

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		ArrayList<Integer> res = longestConsecutiveIncreasingSequence(arr);
		for( int i = 0; i < res.size(); i++ ) {
			System.out.println( res.get(i));
		}
	}

}