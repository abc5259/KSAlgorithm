package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_1748 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int len = s.length();
    int result = 0;
    int lenNum = (int)Math.pow(10,len - 1);
    int mul = 1;
    for(int i=1; i<lenNum; i*=10) {
      result = result + (9 * i * mul);
      mul++;
    }
    int num = Integer.parseInt(s);
    result = result + ((num - lenNum + 1) * len);
    System.out.println(result);
  }
}
