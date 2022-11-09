package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16936 {
  static long[] arr;
  static long[] answer;
  static boolean[] isVisit;
  static int N;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new long[N];
    answer = new long[N];
    isVisit = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) 
      arr[i] = Long.parseLong(st.nextToken());
    solve(0, -1);
  }
  public static void solve(int depth,long prevNum) {
    if(depth == N) {
      for(int i=0; i<N; i++)
        sb.append(answer[i] + " ");
      System.out.println(sb);
      System.exit(0);
      return;
    }
    for(int i=0; i<N; i++) {
      if(!isVisit[i]) {
        long currNum = arr[i];
        if(prevNum != -1) {
          boolean ok = false;
          if((prevNum % 3 == 0 && prevNum / 3 == currNum) || prevNum * 2 == currNum)
            ok = true;
          if(!ok) continue;
        }
        answer[depth] = currNum;
        isVisit[i] = true;
        solve(depth+1,currNum);
        isVisit[i] = false;
        answer[depth] = 0;
      }
    }
  }
}
