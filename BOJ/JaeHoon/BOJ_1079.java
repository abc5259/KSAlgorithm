package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1079 {
  static int N;
  static int[] arr;
  static int[][] R;
  static int ejN;
  static int answer;
  static boolean[] isDead;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    R = new int[N][N];
    isDead = new boolean[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        R[i][j] = Integer.parseInt(st.nextToken());
      } 
    }

    ejN = Integer.parseInt(br.readLine());

    solve(0, N);
    System.out.println(answer);
  }

  public static void solve(int darkCnt, int live) {
    if(isDead[ejN]) {
      answer = Math.max(answer, darkCnt);
      return;
    }
    if(live == 1) {
      answer = Math.max(answer, darkCnt);
      return;
    }
    if(live % 2 == 0) { // 죽여 
      for(int i=0; i<N; i++) {
        if(isDead[i] || ejN == i) continue;
        
        isDead[i] = true;
        for(int j=0; j<N; j++) {
          if(isDead[j]) continue;
          arr[j] += R[i][j];
        }
        solve(darkCnt+1, live-1);
        for(int j=0; j<N; j++) {
          if(isDead[j]) continue;
          arr[j] -= R[i][j];
        }
        isDead[i] = false;
      }
    }else { // 투표요 
      int maxIndex = -1;
      int max = 0;
      for(int i=0; i<N; i++) {
        if(isDead[i]) continue;
        if(arr[i] > max) {
          max = arr[i];
          maxIndex = i;
        }
      }
      isDead[maxIndex] = true;
      solve(darkCnt, live-1);
      isDead[maxIndex] = false;
    }
  }
}
