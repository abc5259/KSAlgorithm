package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2616 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] sum = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      sum[i] += sum[i-1] + Integer.parseInt(st.nextToken());
    }
    int limit = Integer.parseInt(br.readLine());

    int[][] dp = new int[4][N+1];


    for(int i=1; i<=3; i++) {
      for(int j=i*limit; j<=N; j++) {
        // i개의 기관차를 이용해 j개까지의 객차를 끌때 최대 운송 인원 
        // dp[i][j-1] -> j번째 객차를 선택하지 않을때 
        // dp[i-1][j-limit] + sum[j] - sum[j-limit] -> j번째 객차를 선택했을때 누적합 + i-1개의 기관차를 이용해 j-limit만큼 객차를 끌때 
        // j-limit를 한 이유는 i번째 기관차가 j-limit+1 ~ j까지 객차를 끌게 되므로 이전 객차는 j-limit+1 ~ j까지의 객차를 이용못함
        // 따라서 j-limit객차까지 끌때 최댓값을 더해주면 됨 
        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-limit] + sum[j] - sum[j-limit]);
      }
    }

    System.out.println(dp[3][N]);
  
  }
}
