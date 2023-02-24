package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20543 {
  static int N,M;
  static long[][] map;
  static long[][] sum;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new long[N+1][N+1];
    sum = new long[N+1][N+1];
    long[][] ans = new long[N+1][N+1];

    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; j++) {
        map[i][j] = -1 * Long.parseLong(st.nextToken());
      }  
    }

    if(M != 1) {
      for(int i=1; i<=N; i++) {
        for(int j=1; j<=N; j++) { 
          sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
          long getS = getSum(i, j);
          System.out.println("i = " + i + " j = " + j + " getS = " + getS);
          long dif = map[i][j] - getS;
          if (dif > 0) {
            sum[i][j] += dif;
            ans[i + M / 2][j + M / 2] += dif;
          }
        }  
      }
    }else {
      for(int i=1; i<=N; i++) {
        for(int j=1; j<=N; j++) { 
          ans[i][j] = map[i][j];
        }  
      }
    }
    
    StringBuffer sb = new StringBuffer();
    // for(int i=0; i<=N; i++) {
      
    //   for(int j=0; j<=N; j++) {
    //     sb.append(sum[i][j] + " ");
    //   }  
    //   sb.append("\n");
    // }
    // sb.append("\n");
    for(int i=1; i<=N; i++) {
      
      for(int j=1; j<=N; j++) {
        sb.append(ans[i][j] + " ");
      }  
      sb.append("\n");
    }
    System.out.println(sb);
  }
  private static long getSum(int i, int j) {
    int i2 = Math.max(0, i - M);
    int j2 = Math.max(0, j - M);
    return sum[i][j] - sum[i][j2] - sum[i2][j] + sum[i2][j2];
  }
  
}
