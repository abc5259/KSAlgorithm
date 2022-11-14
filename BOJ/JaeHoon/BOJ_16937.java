package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16937 {
  static int H,W,N;
  static int[][] board;
  static int[][] shape;
  static boolean[] isVisit;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    board = new int[H][W];
    shape = new int[N][2];
    isVisit = new boolean[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      shape[i][0] = Integer.parseInt(st.nextToken());
      shape[i][1] = Integer.parseInt(st.nextToken());
    }
    for(int i=0; i<N-1; i++) {
      for(int j=i+1; j<N; j++) {
        if((shape[i][0] + shape[j][0] <= H && Math.max(shape[i][1], shape[j][1]) <= W) || 
          (shape[i][0] + shape[j][0] <= W && Math.max(shape[i][1], shape[j][1]) <= H)
        ) {
          answer = Math.max(answer, shape[i][0] * shape[i][1] + shape[j][0] * shape[j][1]);
        }
        else if((shape[i][0] + shape[j][1] <= H && Math.max(shape[i][1], shape[j][0]) <= W) || 
        (shape[i][0] + shape[j][1] <= W && Math.max(shape[i][1], shape[j][0]) <= H)) {
          answer = Math.max(answer, shape[i][0] * shape[i][1] + shape[j][0] * shape[j][1]);
        }
        else if((shape[i][1] + shape[j][0] <= H && Math.max(shape[i][0], shape[j][1]) <= W) || 
        (shape[i][1] + shape[j][0] <= W && Math.max(shape[i][0], shape[j][1]) <= H)) {
          answer = Math.max(answer, shape[i][0] * shape[i][1] + shape[j][0] * shape[j][1]);
        }
        else if((shape[i][1] + shape[j][1] <= H && Math.max(shape[i][0], shape[j][0]) <= W) || 
        (shape[i][1] + shape[j][1] <= W && Math.max(shape[i][0], shape[j][0]) <= H)) {
          answer = Math.max(answer, shape[i][0] * shape[i][1] + shape[j][0] * shape[j][1]);
        }
      }
    }
    System.out.println(answer);
  } 
}




