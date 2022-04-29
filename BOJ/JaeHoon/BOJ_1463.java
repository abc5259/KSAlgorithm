package BOJ.JaeHoon;
import java.util.Scanner;

public class BOJ_1463 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] D = new int[1000001];
    D[0] = 0;
    D[1] = 0;
    for(int i=2; i<D.length; i++) {
      int a = 1000001;
      int b = 1000001;
      int c;
      if(i %3 == 0) {
        a = D[i/3] + 1;
      }
      if(i % 2 == 0) {
        b = D[i/2] + 1;
      }
      c = D[i-1] + 1;
      D[i] = Math.min(a, Math.min(b,c));
    }
    System.out.println(D[N]);
  }
}
