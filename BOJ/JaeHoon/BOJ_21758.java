package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21758 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[] sum = new int[N+1];
    st = new StringTokenizer(br.readLine());
    int max = 0;
    for(int i=1; i<=N; i++) {
      sum[i] = Integer.parseInt(st.nextToken()) + sum[i-1];
      if(i != 1 && i != N) max = Math.max(max, sum[i] - sum[i-1]);
    }

    int answer = sum[N-1] - sum[1] + max;

    for(int i=2; i<N; i++) {
      int honey = sum[i-1] - sum[1] + (sum[N] - sum[i])*2;
      answer = Math.max(answer, honey);
    }

    for(int i=N-1; i>=2; i--) {
      int honey = sum[N-1] - sum[i] + sum[i-1]*2;
      answer = Math.max(answer, honey);
    }

    System.out.println(answer);
  }
}
