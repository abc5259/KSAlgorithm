package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11265 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] dist = new int[N+1][N+1];
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; j++) {
        dist[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int k=1; k<=N; k++) {
      for(int i=1; i<=N; i++) {
        for(int j=1; j<=N; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);   
        }
      }
    }
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      if(dist[v1][v2] <= time) sb.append("Enjoy other party\n");
      else sb.append("Stay here\n");
    }
    System.out.println(sb);
  }
}
