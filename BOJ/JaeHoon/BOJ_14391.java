package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391 {
  static int N;
  static int M;
  static int[] arr;
  static int result = 0;
  static boolean[] visit;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N*M];
    visit = new boolean[N*M];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        arr[i*M+j] = s.charAt(j) - '0';
      }
    }
    solve(0);
    System.out.println(result);
  }

  public static void solve(int depth) {
    if(depth == N*M) {
      check();
      return;
    }
    visit[depth] = true;
    solve(depth+1);

    visit[depth] = false;
    solve(depth+1);
  }

  public static void check() {
    int sum = 0;
    for(int i=0; i<N; i++) {
      int temp = 0;
      for(int j=0; j<M; j++) {
        if(visit[i*M + j]) {
          temp *= 10;
          temp += arr[i*M + j];
        }else {
          sum += temp;
          temp = 0;
        }
      }
      sum+=temp;
    }
    for(int j=0; j<M; j++) {
      int temp = 0;
      for(int i=0; i<N; i++) {
        if(!visit[i*M + j]) {
          temp *= 10;
          temp += arr[i*M + j];
        }else {
          sum += temp;
          temp = 0;
        }
      }
      sum+=temp;
    }
    result = Math.max(result, sum);
  }
}
