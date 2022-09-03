package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11397 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[] height = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        height[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(height);
      int dif = Integer.MIN_VALUE;
      int right = height[N-1];
      int left = height[N-1];
      boolean isRight = true;
      for(int j=N-2; j>=1; j--) {
        if(isRight) {
          dif = Math.max(dif, Math.abs(right - height[j]));
          right = height[j];
        }else {
          dif = Math.max(dif, Math.abs(left - height[j]));
          left = height[j];
        }
        isRight = !isRight;
      }
      if(isRight) {
        dif = Math.max(dif, Math.abs(right - height[0]));
      }else {
        dif = Math.max(dif, Math.abs(left - height[0]));
      }
      sb.append(dif).append('\n');
    }
    System.out.println(sb);
  }
}
