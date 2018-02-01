import java.util.ArrayList;
import java.util.Scanner;

public class GuessDataStructures {
    
    public static int largestElementOf(ArrayList<Integer> DS)
    {
        int max = 0;
        for(int i=0; i < DS.size(); i++)
        {
            if(max < DS.get(i)) max = DS.get(i);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()) {
            int n = sc.nextInt();
            
            ArrayList<Integer> DS = new ArrayList<Integer>();
            
            int isStack = 0;
            int isQueue = 0;
            int isPriorQueue = 0;
            int impossible = 0;
            int numOf2s = 0;
            
            //ultimately, it's to see which one = #of 2's (=X) at the end.
            //if more than 1 = X then "not sure"
            //if(isStack = X && other 2 < X) "stack"
            //else if(isQueue = X && other 2 < X) "queue"
            //else if(isPriorQueue = X && other 2 < X) "priorqueue"
            //else if(isStack && isQueue=X || isStack && isPriorQueue=X || queue&&prior = X)"not sure"
            //else "impossible"
            
            
            
            int i = 0;
            while (i < n)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                if(i== 0 && a == 2) {impossible = 1;}
                
                else if(a == 1)
                {
                    DS.add(b);
                }
                else if(a == 2)
                {
                    numOf2s++;
                    if(b == DS.get(0)) isQueue++;
                    if(b == DS.get(DS.size()-1)) isStack++;
                    if(b == largestElementOf(DS)) isPriorQueue++;
                    if(!DS.contains(b)) { impossible = 1;}
                    if(DS.contains(b)) DS.remove(DS.indexOf(b));
                    
                }
                
                i++;
            }
            if(impossible == 1) {System.out.println("impossible");}
            else if(isQueue == numOf2s && isStack !=numOf2s && isPriorQueue!=numOf2s) System.out.println("queue");
            else if(isStack == numOf2s && isQueue !=numOf2s && isPriorQueue!=numOf2s) System.out.println("stack");
            else if(isPriorQueue == numOf2s && isStack !=numOf2s && isQueue!=numOf2s) System.out.println("priority queue");
            else if( (isQueue==numOf2s && isStack==numOf2s) || (isQueue==numOf2s && isPriorQueue==numOf2s) || (isStack==numOf2s && isPriorQueue==numOf2s)) System.out.println("not sure");
            else System.out.println("impossible");
        }
    }
    
}
