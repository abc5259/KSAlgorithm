package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2492 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] X = new int[T];
    int[] Y = new int[T];
    for(int i=0; i<T; i++)  {
      st = new StringTokenizer(br.readLine());
      X[i] = Integer.parseInt(st.nextToken());
      Y[i] = Integer.parseInt(st.nextToken());
    }
    int max = Integer.MIN_VALUE;
    int resultX = 0;
    int resultY = 0;
    for(int i=0; i<T; i++) {
      for(int j=0; j<T; j++) {
        int x = X[i] + K > N ? N - K : X[i];
        int y = Y[j] + K > M ? M - K : Y[j];
        int count = 0;
        for(int l=0; l<T; l++) {
          if(x <= X[l] && X[l] <= x+K && y <= Y[l] && Y[l] <= y+K) {
            count++;
          }
        }
        if(count > max) {
          resultX = x;
          resultY = y+K;
          max = count;
        }
      }
    }
    System.out.println(resultX + " " + resultY);
    System.out.println(max);
  }
}
