import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int[] h = new int[n+1];
			for(int i = 1; i < n+1; i++)
			{
				h[i] = s.nextInt();
			}
			
			
			//System.out.println(Arrays.toString(h));
			
			boolean [] kh = new boolean[n+1];
			
			
			int[] r = new int[n+1];
			for(int i=1; i < n+1; i++)
			{
				kh[h[i]-1] = true;
				if(!kh[h[i]])
				{
					r[i] = r[i-1]+1;
				}
				else
					r[i] = r[i-1];
			}
			
			//System.out.println(Arrays.toString(r));
			System.out.println(r[r.length-1]);
		
	}
}
