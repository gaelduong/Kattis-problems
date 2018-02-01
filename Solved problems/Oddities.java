import java.util.Scanner;

public class Odd {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int i = 0;
		while (i < n) {
		   long a = sc.nextLong();
		   if(a % 2 == 0) System.out.println(a + " is even");
		   else System.out.println(a + " is odd");
		   i++;
		}
	}

}


