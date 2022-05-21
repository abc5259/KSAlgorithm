package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_6064 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<T; i++) {
      int M = sc.nextInt();
      int N = sc.nextInt();
      int X = sc.nextInt();
      int Y = sc.nextInt();
      int max = M * N;
      int k = 0; 
      while(true) {
        if((M * k + X )%N == Y)  {
          k = M * k + X;
          break;
        }
        if(M * k + X  > max) {
          k = -1;
          break;
        }
        k++;
      }
      sb.append(k).append("\n");
    }
    System.out.println(sb);
  }
}
