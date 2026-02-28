package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1421 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    int max = 0;
    for(int i=0; i<N; i++) {
      int v = Integer.parseInt(br.readLine());
      arr[i] = v;
      max = Math.max(max, v);
    }

    long answer = 0;
    for(int i=1; i<=max; i++) {
      long cnt = 0;
      long cutCnt = 0;
      for(int j=0; j<N; j++) {
        int c = arr[j] / i;
        cnt += c;
        int b = arr[j] % i;
        if(c != 0) {
          if(i == arr[j]) {}
          else if(b == 0) {
            if(c*i*W - (c-1)*C <= 0) {
              cnt -= c;
            }else {
              cutCnt += c - 1;
            }
          }
          else {
            if(c*i*W - c*C <= 0) {
              cnt -= c;
            }else {
              cutCnt += c;
            }
          }
        }
        
      }
      answer = Math.max(answer, cnt*W*i - cutCnt * C);
    }

    System.out.println(answer);
  }
}
