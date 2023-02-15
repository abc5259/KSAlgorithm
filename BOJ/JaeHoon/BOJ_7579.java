package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {
  static int N,M;
  static int[] memory;
  static int[] cost;
  static int memoryMax;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    memory = new int[N];
    cost = new int[N];
    st = new StringTokenizer(br.readLine());
    int sum = 0;
    for(int i=0; i<N; i++) {
      memory[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
      sum += cost[i];
    }
    
    int[] dp = new int[sum+1];
    for(int i=0; i<N; i++) {
      for(int j=sum; j>=0; j--) {
        if(j + cost[i] <= sum && dp[j] != 0) {
          dp[j+cost[i]] = Math.max(dp[j+cost[i]], dp[j] + memory[i]);
        }
      }
      dp[cost[i]] = Math.max(dp[cost[i]], memory[i]);
    }
    int answer = 0;
    for(int i=0; i<=sum; i++) {
      if(dp[i] >= M) {
        answer = i;
        break;
      }
    }
    System.out.println(answer);
  }
}
