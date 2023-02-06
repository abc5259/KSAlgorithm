package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19542 {
  static int N,S,D;
  static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
  static boolean[] isVist;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    for(int i=0; i<=N; i++) {
      tree.add(new ArrayList<>());
    }

    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      tree.get(v1).add(v2);
      tree.get(v2).add(v1);
    }

    isVist = new boolean[N+1];
    isVist[S] = true;
    dfs(S);
    System.out.println(Math.max(0, (answer-1) * 2));
  }
  public static int dfs(int idx) {
    int maxDepth = 0;
    
    for(int next: tree.get(idx)) {
      if(isVist[next]) continue;
      isVist[next] = true;
      maxDepth = Math.max(maxDepth, dfs(next));
    }

    if(maxDepth >= D) {
      // System.out.println("idx= " + idx + " maxDepth = " + maxDepth);
      answer++;
    }

    return maxDepth + 1;
  }
}
