package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] A = new int[N];
    int[] B = new int[M];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }
    int A_index = 0;
    int B_index = 0;
    int totalIndex = 0;
    StringBuffer sb = new StringBuffer();
    while(totalIndex < N + M) {
      if(A_index < N && B_index < M) {
        if(A[A_index] <= B[B_index]) {
          sb.append(A[A_index]).append(" ");
          A_index++;
        }
        else{
          sb.append(B[B_index]).append(" ");
          B_index++;
        }
      }
      else if(A_index == N) {
        sb.append(B[B_index]).append(" ");
        B_index++;
      }
      else {
        sb.append(A[A_index]).append(" ");
        A_index++;
      }
      totalIndex++;
    }
    System.out.println(sb);
  }
}
