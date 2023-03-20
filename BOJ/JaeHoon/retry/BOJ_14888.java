package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
  static int N;
  static int[] A;
  static int[] op;
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    A = new int[N];
    op = new int[4];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<4; i++) {
      op[i] = Integer.parseInt(st.nextToken());
    }

    solve(0, A[0]);

    System.out.println(max);
    System.out.println(min);
  }
  public static void solve(int depth,int n) {
    if(depth == N-1) {
      max = Math.max(max, n);
      min = Math.min(min, n);
      return;
    }

    for(int i=0; i<4; i++) {
      if(op[i] > 0) {
        op[i]-=1;
        if(i == 0) {
          solve(depth+1, n+A[depth+1]);
        }
        else if(i == 1) {
          solve(depth+1, n-A[depth+1]);
        }
        else if(i == 2) {
          solve(depth+1, n*A[depth+1]);
        }
        else if(i == 3) {
          solve(depth+1, n/A[depth+1]);
        }
        op[i] += 1;
      }
    }
  }
}
