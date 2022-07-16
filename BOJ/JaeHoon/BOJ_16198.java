package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16198 {
  static int[] map;
  static boolean[] isVisit;
  static int result = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    map = new int[N];
    isVisit = new boolean[N];
    for(int i=0; i<N; i++) {
      map[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0, 0, N);
    System.out.println(result);
  }
  public static void dfs(int depth,int sum,int N) {
    if(depth == N-2) {
      result = Math.max(result, sum);
      return;
    }
    for(int i=1; i<N-1; i++) {
      if(!isVisit[i]) {
        isVisit[i] = true;
        int prevIndex = i-1;
        int nextIndex = i+1;
        while(prevIndex > 0 && isVisit[prevIndex]) {
          prevIndex--;
        }
        while(nextIndex < N && isVisit[nextIndex]) {
          nextIndex++;
        }
        sum += (map[prevIndex] * map[nextIndex]);
        dfs(depth+1,sum, N);
        sum -= (map[prevIndex] * map[nextIndex]);
        isVisit[i] = false;
      }
    }
  }
}