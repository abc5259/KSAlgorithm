package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20002 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[][] map = new int[N+1][N+1];


    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; j++) {
        map[i][j] += map[i-1][j] + map[i][j-1] + Integer.parseInt(st.nextToken()) - map[i-1][j-1];
      }
    }

    int max = Integer.MIN_VALUE;

    for(int i=1; i<=N; i++) {
      for(int j=1; j<=N; j++) {
        int maxSize = N - Math.max(i, j) + 1;
        for(int s=1; s<=maxSize; s++) {
          int r = i+s-1;
          int c = j+s-1;
          int sum = map[r][c] - map[r][c-s] - map[r-s][c] + map[r-s][c-s];
          max = Math.max(sum, max);
        }
      } 
    }

    System.out.println(max);
  }
}
