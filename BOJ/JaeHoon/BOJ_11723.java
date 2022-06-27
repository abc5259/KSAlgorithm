package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    int S = 0;
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      if(s.equals("add")) {
        int n = Integer.parseInt(st.nextToken()) - 1;
        S |= (1 << n);
      }
      else if(s.equals("remove")) {
        int n = Integer.parseInt(st.nextToken()) - 1;
        S &= ~(1 << n);
      }
      else if(s.equals("check")) {
        int n = Integer.parseInt(st.nextToken()) - 1;
        sb.append((S & (1 << n)) != 0 ? 1 : 0).append('\n');
      }
      else if(s.equals("toggle")) {
        int n = Integer.parseInt(st.nextToken()) - 1;
        S ^= (1 << n);
      }
      else if(s.equals("all")) {
        S = -1 >> 12;
      }
      else {
        S = 0;
      }
    }
    System.out.println(sb);
  }
}
