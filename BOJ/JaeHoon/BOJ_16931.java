package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] shape = new int[N][M];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        shape[i][j] = Integer.parseInt(st.nextToken());
      } 
    }

    int sum = N*M*2;
    for(int i=0; i<N; i++) {
      sum += shape[i][0];
      for(int j=1; j<M; j++) {
        if(shape[i][j] > shape[i][j-1]) {
          sum += shape[i][j] - shape[i][j-1];
        }
      }
      sum += shape[i][M-1];
      for(int j=M-2; j>=0; j--) {
        if(shape[i][j] > shape[i][j+1]) {
          sum += shape[i][j] - shape[i][j+1];
        }
      }
    }

    for(int j=0; j<M; j++) {
      sum += shape[0][j];
      for(int i=1; i<N; i++) {
        if(shape[i][j] > shape[i-1][j]) {
          sum += shape[i][j] - shape[i-1][j];
        }
      }
      sum += shape[N-1][j];
      for(int i=N-2; i>=0; i--) {
        if(shape[i][j] > shape[i+1][j]) {
          sum += shape[i][j] - shape[i+1][j];
        }
      }
    }
    System.out.println(sum);
  }
}
  