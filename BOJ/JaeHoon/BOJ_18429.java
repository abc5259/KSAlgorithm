package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {
  static int N,K;
  static int[] kits;
  static int[] arr;
  static boolean[] isVisit;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    kits = new int[N];
    arr = new int[N];
    isVisit = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      kits[i] = Integer.parseInt(st.nextToken());
    }
    solve(0);
    System.out.println(answer);
  }
  public static void solve(int depth) {
    if(depth == N) {
      if(check()) answer++;
      return;
    }

    for(int i=0; i<N; i++) {
      if(!isVisit[i]) {
        arr[depth] = kits[i];
        isVisit[i] = true;
        solve(depth+1);
        isVisit[i] = false;
        arr[depth] = 0;
      }
    }
  }
  public static boolean check() {
    int weight = 500;
    for(int i=0; i<N; i++) {
      weight += arr[i] - K;
      if(weight < 500) return false;
    }
    return true;
  }
}
