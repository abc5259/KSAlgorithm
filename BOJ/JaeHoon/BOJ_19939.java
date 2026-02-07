package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19939 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int sum = 0;
    for(int i=1; i<=K; i++) {
      sum += i;
    }

    if(N < sum) {
      System.out.println(-1);
      return;
    }

    N = N - sum;
    N %= K;
    if(N == 0) {
      System.out.println(K - 1);
    }else {
      System.out.println(K);
    }
  }
}
