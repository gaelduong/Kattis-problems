import java.util.Arrays;
import java.util.Scanner;

public class Natrij {
	public static void main(String[] args) {
		//convert both to seconds
		//convert seconds back to format
		//System.out.println(40000-120000);
		
		/*
		 12:34:56
	     14:36:22
		 */
		
		Scanner sc = new Scanner(System.in);
		String s =  sc.nextLine();
		s = s.replaceAll(":", "");
		String f = sc.nextLine();
		f = f.replaceAll(":", "");
		//System.out.println(s + " " + f);
		int [] fs = new int[3];
		fs[2] = Integer.parseInt(f.charAt(4)+""+f.charAt(5));
		fs[1] = Integer.parseInt(f.charAt(2)+""+f.charAt(3));
		fs[0] = Integer.parseInt(f.charAt(0)+""+f.charAt(1));
		//System.out.println(fs[2]);
		
		int[] ss = new int[3];
		ss[2] = Integer.parseInt(s.charAt(4)+""+s.charAt(5));
		ss[1] = Integer.parseInt(s.charAt(2)+""+s.charAt(3));
		ss[0] = Integer.parseInt(s.charAt(0)+""+s.charAt(1));
		//System.out.println(ss[2]);
		
		int[] r = new int[3];
		if(ss[2]>fs[2]) ss[1]++;
		if(ss[1]>fs[1]) ss[0]++;
		
		//System.out.println(Arrays.toString(fs));
		//System.out.println(Arrays.toString(ss));
		
		r[2] = (fs[2]+60-ss[2])%60;
		r[1] = (fs[1]+60-ss[1])%60;
		r[0]  = (fs[0]+24-ss[0])%24;
		//System.out.println(Arrays.toString(r));
		
		String d = "";
		for(int i=0; i<r.length;i++)
		{
			if(r[i] < 10) d += "0"+r[i];
			else d = d + r[i];
			
			if(i!=2) d+=":";
		}
		
		if(r[0]+r[1]+r[2]==0) d = "24:00:00";
		System.out.println(d);
		
		
		
		
	
		
	}

}
