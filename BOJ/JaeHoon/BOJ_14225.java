package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14225 {
  static int[] num;
  static boolean[] isVisit;
  static boolean[] isUse;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    num = new int[N];
    isVisit = new boolean[N];
    isUse = new boolean[100000*20 + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0,0);
    for(int i=1; i<isUse.length; i++) {
      if(!isUse[i]) {
        System.out.println(i);
        break;
      }
    }
  }
  public static void dfs(int depth,int sum) {
    if(depth == N) {
      System.out.println(sum);
      isUse[sum] = true;
      return;
    }
    dfs(depth+1,sum+num[depth]);
    dfs(depth+1,sum);
  }
}
