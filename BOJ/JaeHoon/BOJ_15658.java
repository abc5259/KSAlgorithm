package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15658 {
  static int[] arr;
  static int[] operator; 
  static int N;
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[N];
    operator = new int[4];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0, arr[0]);
    System.out.println(max);
    System.out.println(min);
  }
  public static void dfs(int depth,int sum) {
    if(depth == N-1) {
      min = Math.min(min, sum);
      max = Math.max(max, sum);
      return;
    }
    for(int i=0; i<4; i++) {
      if(operator[i] > 0) {
        operator[i] -= 1;
        switch (i) {
          case 0:
            dfs(depth+1,sum+arr[depth+1]);
            break;
          case 1:
            dfs(depth+1,sum-arr[depth+1]);
            break;
          case 2:
            dfs(depth+1,sum*arr[depth+1]);
            break;
          case 3:
            dfs(depth+1,sum/arr[depth+1]);
            break;
        }
        operator[i] += 1;
      }
    }
  }
}
