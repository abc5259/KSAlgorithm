package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_1107 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    boolean[] broken = new boolean[10];
    for(int i=0; i<M; i++) {
      int index = sc.nextInt();
      broken[index] = true;
    }
    int result = Math.abs(N - 100);
    for(int i=0; i<=999999; i++) {
      //i를 리모콘으로 누를 수 있는지 
      String num = String.valueOf(i);
      if(check(num, broken)) {
        result = Math.min(result, Math.abs(N - i) + num.length());
      }
    }
    System.out.println(result);
  }
  public static boolean check(String num, boolean[] broken) {
    boolean result = true;
    for(int j=0; j<num.length(); j++) {
      int n = num.charAt(j) - '0';
      if(broken[n]) 
        return false;
    }
    return result;
  }
}
