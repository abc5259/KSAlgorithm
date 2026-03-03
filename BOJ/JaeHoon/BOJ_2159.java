package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2159 {
  static int[] dx = {0,0,0,-1,1};
  static int[] dy = {0,1,-1,0,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N+1][2];
    long[][] dp = new long[N+1][5];

    int[] start = new int[2];
    st = new StringTokenizer(br.readLine());
    start[0] = Integer.parseInt(st.nextToken());
    start[1] = Integer.parseInt(st.nextToken());

    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
      Arrays.fill(dp[i], 200_000L * 100_000 + 1);
    }

    for(int d=0; d<5; d++) {
      int nx = arr[1][0] + dx[d];
      int ny = arr[1][1] + dy[d];
      if(nx <= 0 || nx > 100_000 || ny <= 0 || ny > 100_000) continue;
      dp[1][d] = dist(start[0], start[1], nx, ny);
    }
    
    for(int i=2; i<=N; i++) {
      for(int d=0; d<5; d++) {
        int nx = arr[i][0] + dx[d];
        int ny = arr[i][1] + dy[d];
        if(nx <= 0 || nx > 100_000 || ny <= 0 || ny > 100_000) continue;
        for(int dd=0; dd<5; dd++) {
          int nnx = arr[i-1][0] + dx[dd];
          int nny = arr[i-1][1] + dy[dd];
          if(nnx <= 0 || nnx > 100_000 || nny <= 0 || nny > 100_000) continue;
          dp[i][d] = Math.min(dp[i][d], dp[i-1][dd] + dist(nx, ny, nnx, nny));
        }
      } 
    }

    long answer = 200_000L * 100_000 + 1;
    for(int i=0; i<5; i++) {
      answer = Math.min(dp[N][i], answer);
    }
    System.out.println(answer);
  }

  public static long dist(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}
