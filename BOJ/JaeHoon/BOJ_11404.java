package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {
  static final int INF = 987654321;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(br.readLine());

    int[][] dist = new int[N+1][N+1];
    for(int i=1; i<=N; i++) {
      for(int j=1; j<=N; j++) {
        if(i==j) continue;
        dist[i][j] = INF;
      } 
    }
    for(int i=1; i<=M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      dist[v1][v2] = Math.min(dist[v1][v2], cost);
    }
    
    for(int k=1; k<=N; k++) {
      for(int i=1; i<=N; i++) {
        for(int j=1; j<=N; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      } 
    }

    StringBuffer sb = new StringBuffer();

    for(int i=1; i<=N; i++) {
      for(int j=1; j<=N; j++) {
        if(dist[i][j] == INF)
          sb.append(0+ " ");
        else 
          sb.append(dist[i][j]+ " ");
      } 
      sb.append('\n');
    }
    System.out.println(sb);
  }
}
