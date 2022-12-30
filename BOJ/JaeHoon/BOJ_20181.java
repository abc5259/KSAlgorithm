package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20181 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
    }
    
    long[] cache = new long[N+1];
    
    int start = 1, end = 1;
    long sum = 0, answer = 0, max = 0;
    while(end <= N) {
      sum = arr[end] - arr[start-1];
      if(sum >= K) {
        max = Math.max(max, cache[start-1]);
        cache[end] = Math.max(cache[end], max + sum - K);
        start++;
      }
      else end++;
    }

    for(int i=1; i<=N; i++)
      answer = Math.max(answer, cache[i]);
    System.out.println(answer);
  }
}
