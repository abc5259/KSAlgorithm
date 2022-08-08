package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] P = new int[N];
    for(int i=0; i<N; i++) {
      P[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(P);
    int answer = 0;
    int waitTime = 0;
    for(int i=0; i<N; i++) {
      answer += waitTime + P[i];
      waitTime += P[i];
    }
    System.out.println(answer);
  }
}
