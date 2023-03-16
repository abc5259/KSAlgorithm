package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1111 {
  static int N;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    if(N == 1)  {
        System.out.println("A");
    }
    else if(N == 2) {
      if(arr[0] != arr[1]) System.out.println("A");
      else System.out.println(arr[0]);
    }
    else {
      int a = -1;
      int b = -1;

      if(arr[2] == arr[1]) {
        a = 1;
        b = 0;
      }else {
        a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
        b = arr[1] - arr[0]*a;
      }

      if(dfs(a, b, 1)) {
        System.out.println(arr[N-1]*a+b);
      }else {
        System.out.println("B");
      }
    }
  }
  public static boolean dfs(int a, int b, int idx) {
    if(idx >= N-1) {
      return true;
    }

    if(arr[idx]*a + b == arr[idx+1]) {
      if(dfs(a, b, idx+1)) return true;
    }

    return false;
  }
}
 