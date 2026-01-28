package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1464 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int N = s.length();

    int i = 1;
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(0));
    while (i < N) {
      char cur = s.charAt(i);

      if(cur <= sb.charAt(0)) {
        sb.reverse();
        sb.append(cur);
        sb.reverse();
      }else {
        sb.append(cur);
      }
      i++;
    }
    System.out.println(sb);
  }
}
