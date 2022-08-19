package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1201 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();
    if(N >= M+K-1 && N <= M*K) {
      int[] result = new int[M+1];
      result[1] = K;
      N = N - K;
      if(M - 1 > 0) {
        int minLength = N / (M - 1);
        int rest = N % (M - 1);
        for(int i=2; i<=M; i++) {
          if(rest >0) {
            result[i] = result[i-1] + minLength + 1;
            rest--;
          }else {
            result[i] = result[i-1] + minLength;
          }
        }
      }
      for(int i=1; i<result.length; i++) {
        for(int j=result[i]; j>result[i-1]; j--)  {
          sb.append(j).append(" ");
        }
      }
      System.out.println(sb);
    }else {
      System.out.println(-1);
    }
  }
}

/*
 * 4 2 2
 * 1 2 3 4
 * 2 1 4 3 
 * 
 * 4 4 1
 * 1 2 3 4
 * 
 * 4 4 2     -> N과 M이 같다면 K가 1 N과 K가 같다면 M이 1이되야만 만들 수 있음
 * 1 2 3 4
 * 
 * 4 3 1 X
 * 4 1 2 3
 * 
 * 4 3 2
 * 2 1 2 3
 * 
 * 4 3 3
 * 4 1 2 3
 */