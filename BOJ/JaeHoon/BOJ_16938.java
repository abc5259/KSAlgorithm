package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16938 {
  static int N,L,R,X;
  static int[] score;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    score = new int[N];
    for(int i=0; i<N; i++)
      score[i] = Integer.parseInt(st.nextToken());

    for(int i=3; i<1<<N; i++) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      int sum = 0;
      for(int k=0; k<N; k++) {
        if(((1<<k) & i) != 0) {
          min = Math.min(min, score[k]);
          max = Math.max(max, score[k]);
          sum += score[k];
        }
      }
      if(max - min >= X && sum <= R && sum >= L) {
        answer++;
      }
    }
    System.out.println(answer);

  }
}
