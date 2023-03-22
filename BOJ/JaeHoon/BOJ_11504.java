package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11504 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    StringBuffer sb = new StringBuffer();
    for(int t=0; t<T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int X = 0;
      st = new StringTokenizer(br.readLine());
      for(int i=M-1; i>=0; i--) {
        int n = Integer.parseInt(st.nextToken());
        X += n*Math.pow(10, i);
      }
      
      int Y = 0;
      st = new StringTokenizer(br.readLine());
      for(int i=M-1; i>=0; i--) {
        int n = Integer.parseInt(st.nextToken());
        Y += n*Math.pow(10, i);
      }

      int[] circle = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
        circle[i] = Integer.parseInt(st.nextToken());
      }

      int total = 0;
      for(int i=0; i<N; i++) {
        StringBuffer n = new StringBuffer();
        for(int j=i; j<i+M; j++) {
          n.append(circle[j % N]);
        }
        int num = Integer.valueOf(n.toString());
        if(X <= num && num <= Y) total++;
      }
      sb.append(total).append("\n");
    }
    System.out.println(sb);
  }
}
