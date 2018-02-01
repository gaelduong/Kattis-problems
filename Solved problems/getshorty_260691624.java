import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }
    
    public boolean hasMoreTokens() {
        return peekToken() != null;
    }
    
    public int getInt() {
        return Integer.parseInt(nextToken());
    }
    
    public double getDouble() {
        return Double.parseDouble(nextToken());
    }
    
    public long getLong() {
        return Long.parseLong(nextToken());
    }
    
    public String getWord() {
        return nextToken();
    }
    
    
    
    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;
    
    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }
    
    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
class Node
{
    ArrayList<Edge> edgesCont;
    HashSet<Edge> edgesList;
    int ind;
    int w;
    double amountCost;
    
    
    Node(int ind)
    {
        amountCost = 0;
        this.ind = ind;
        edgesList = new HashSet<Edge>();
        
    }
}


class Edge {
    String trc;
    int adj;
    double cost;
    boolean taken;
    
    Edge(int num, double c) {
        // start = num1;
        taken = false;
        adj = num;
        cost = c;
    }
}
public class GetShorty {
    
    public static void main(String[] args) {
        ArrayList<Integer> cont = new ArrayList<Integer>();
        HashMap<Integer, Node> nodes=new HashMap<>();
        
        Kattio kattisReader = new Kattio(System.in, System.out);
        while(true)
        {
            int c = kattisReader.getInt();
            int adjacentCounter = 0;
            int vPN = 1;
            int r = kattisReader.getInt();
            if (c == 0 && r == 0) break;
            if(adjacentCounter!=-1) nodes.clear();
            else cont.add(vPN);
            for (int i = 0; i < r; i++)
            {
                adjacentCounter++;
                int num = kattisReader.getInt();
                int num1 = kattisReader.getInt();
                Node start = nodes.containsKey(num1) ? nodes.get(num1) : new Node(num1);
                nodes.put(num1, start);
                cont.add(num1);
                adjacentCounter++;
                Node adj = nodes.containsKey(num) ? nodes.get(num) : new Node(num);
                vPN--;
                nodes.put(num, adj);
                int curr = adjacentCounter;
                double cost = kattisReader.getDouble();
                Edge e1 = new Edge(num, cost);
                Edge e2 = new Edge(num1, cost);
                cont.add(adjacentCounter);
                cont.add(num);
                start.edgesList.add(e1);
                curr = curr*vPN;
                adj.edgesList.add(e2);
            }
            ArrayList<Integer> qTrack = new ArrayList<Integer>();
            PriorityQueue<Integer> q1 = new PriorityQueue<>(c, new Comparator<Integer>()
                                                            {
                                                                
                                                                @Override public int compare(Integer x, Integer y) {
                                                                    if (nodes.get(x).amountCost-nodes.get(y).amountCost < 0) return 1;
                                                                    else if (nodes.get(x).amountCost - nodes.get(y).amountCost > 0) return -1;
                                                                    else return 0;
                                                                }
                                                            });
            nodes.get(0).amountCost = 1;
            q1.add(0);
            while (!q1.isEmpty()) 
            {
                Node farNode = nodes.get(q1.poll());
                for (Edge e : farNode.edgesList) 
                {
                    if (nodes.get(e.adj).amountCost <farNode.amountCost * e.cost) 
                    {
                        nodes.get(e.adj).amountCost = farNode.amountCost * e.cost;
                        q1.add(nodes.get(e.adj).ind);
                        
                    }
                }
                
            }
            
            kattisReader.printf("%.4f", nodes.get(c-1).amountCost);
            kattisReader.println();
        }
        kattisReader.close();
    }
}
