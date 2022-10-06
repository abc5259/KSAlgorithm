package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16922 {
  static int[] arr = {1,5,10,50};
  static int N,answer;
  static boolean[] isVisit = new boolean[50 * 20 + 1];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    dfs(0, 0,0);
    System.out.println(answer);
  }
  public static void dfs(int depth,int num,int index) {
    if(depth == N) {
      if(!isVisit[num]) {
        isVisit[num] = true;
        answer++;
      }
      return;
    }
    for(int i=index; i<4; i++) {
      dfs(depth+1, num+arr[i],i);
    }

  }
}
