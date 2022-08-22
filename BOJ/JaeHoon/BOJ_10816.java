package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int N = Integer.parseInt(st.nextToken());
    int[] visit = new int[20000001];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      visit[Integer.parseInt(st.nextToken())+10000000] += 1;
    }
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++) {
      sb.append(visit[Integer.parseInt(st.nextToken())+10000000]).append(" ");
    }
    System.out.println(sb);
  }
}
