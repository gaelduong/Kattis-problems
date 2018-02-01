import java.util.*;
public class bq {
	
    //method finding the index of min time
	public static int getMinIndex(int[] array, int index)
	{
		int minIndex = index;
		for (int i = index; i < array.length; i++)
			if (array[i] < array[minIndex]) minIndex = i;
		return minIndex;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int T = scan.nextInt();
		
		int[] cost = new int[N];
		int[] time = new int[N];
		for (int i = 0; i < N; i++)
		{
			cost[i] = scan.nextInt();
			time[i] = scan.nextInt() + 1;
		}
		
        //sorting the list in function of time (putting smallest times in front)
		for (int i = 0; i < N; i++)
		{
			int minIndex = getMinIndex(time, i);
			if (i != minIndex) 
			{
				
				int tmp = time[minIndex];
				time[minIndex] = time[i];
				time[i] = tmp;

				int tmp2 = cost[minIndex];
				cost[minIndex] = cost[i];
				cost[i] = tmp2;

			}
		}
		
        //construct table
		int[][] memo = new int[N+1][T+1];
		for (int i = 0; i < N+1; i++)
			for (int j = 0; j < T+1; j++)
			{
				if (i==0 || j==0) memo[i][j] = 0;
				else if (j <= time[i-1]) memo[i][j] = Math.max( cost[i-1] + memo[i-1][j-1], memo[i-1][j] );
				else memo[i][j] = memo[i-1][j];
			}
		
		int sum = 0;
		for (int i = 0; i < T + 1; i++)
			if (memo[N][i] > sum) sum = memo[N][i];
		
		System.out.println(sum);
		
		scan.close();
	}
	
	
	
	
}
