package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_1476 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int e =0;
		int s = 0;
		int m = 0;
		int year = 0;
		while(e != E || s != S || m !=M) {
			e++; 
			s++; 
			m++;
			year++;
			if(e > 15) 
				e = 1;
			if(s > 28)
				s = 1;
			if(m > 19) 
				m = 1;
		}
		System.out.println(year);
  }
}
