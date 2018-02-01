import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RestoOrders {
    
    public static void main(String[] args) {
        
        
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        
        int numOfDishes = sc.nextInt();
        
        String getN = sc.next();
        String[] N = getN.split(" ");
        
        /*list of prices*/
        ArrayList<Integer> n = new ArrayList<Integer>();
        n.add(0);
        for(int i=1; i<numOfDishes+1;i++) n.add(Integer.parseInt(N[i-1]));
        //System.out.println(Arrays.toString(n.toArray()));
        
        
        
        int numOfOrders = sc.nextInt();
        String getM = sc.next();
        String[] M = getM.split(" ");
        
        
        int max = -2;
        int indexOfMaxSum = -1;
        
        /*list of orders (sums)*/
        int[] sums = new int[numOfOrders];
        for(int i=0; i<sums.length;i++)
        {
            sums[i] = Integer.parseInt(M[i]);
            if(sums[i] > max) {max = sums[i]; indexOfMaxSum = i;}
        }
        
        //System.out.println(Arrays.toString(m));
        
        
        //System.out.println(indexOfMaxSum);
        
        /*magic array -a-*/
        int[] a = new int[sums[indexOfMaxSum]+1];
        
        //int[] s = {45,51,71,83};
        
        for(int k=1; k< n.size(); k++)
        {
            for(int i=1; i < a.length; i++)
            {
                if(a[i] != -1)
                {
                    if( (i % n.get(k) == 0 || i >= n.get(k) && a[i-n.get(k)] !=0))
                    {
                        if(a[i] == 0) a[i] = k;
                        else a[i] = -1;
                    }
                }
                
            }
        }
        //System.out.println(Arrays.toString(a));
        
        
        /*get soln*/
        for(int j = 0; j < sums.length; j++)
        {
            String soln = "";
            
            int increment = 0;
            if(a[sums[j]] == 0) {soln = "Impossible";}
            else
            {
                for(int i = sums[j]; i > 0; i -= increment)
                {
                    if(a[i] == -1) 
                    {
                        
                        soln = "Ambiguous";
                        break;
                    }
                    else
                    {
                        soln =  a[i] + " " + soln;
                        increment = n.get(a[i]);
                        
                    }
                    
                    
                }
                
                
            }
            System.out.println(soln);
        }
        
        
        
    }
    
}
