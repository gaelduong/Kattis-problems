import java.util.Scanner;

public class t9spelling {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int k=0;
		sc.nextLine();
	
		while(k<n)
		{
			
			String s = sc.nextLine();
			//System.out.println(s);
			String r = "";
			
			for(int i=0; i<s.length();i++)
			{
				String a = "";
				switch(s.charAt(i))
				{
				case 'a': a="2";break;
				case 'b': a="22";break;
				case 'c': a="222";break;
				case 'd': a="3";break;
				case 'e': a="33";break;
				case 'f': a="333";break;
				case 'g': a="4";break;
				case 'h': a="44";break;
				case 'i': a="444";break;
				case 'j': a="5";break;
				case 'k': a="55";break;
				case 'l': a="555";break;
				case 'm': a="6";break;
				case 'n': a="66";break;
				case 'o': a="666";break;
				case 'p': a="7";break;
				case 'q': a="77";break;
				case 'r': a="777";break;
				case 's': a="7777";break;
				case 't': a="8";break;
				case 'u': a="88";break;
				case 'v': a="888";break;
				case 'w': a="9";break;
				case 'x': a="99";break;
				case 'y': a="999";break;
				case 'z': a="9999";break;
				case ' ': a="0";break;
				}
				
				//if(i>0) System.out.println("r: "+r + " a: "+a );
				if(i > 0 && r.charAt(r.length()-1) == a.charAt(0))
				{
					
					r+= " " + a;
				}
				else
				{
					r+=a;
			
				}
				//System.out.println("a is: "+a);
				
			}
			
			System.out.println("Case #"+(k+1)+": "+r);
			
			k++;
		}
	
	}

}
