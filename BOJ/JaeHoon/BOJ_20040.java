package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20040 {
  static int[] parents;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int answer = 0;
    parents = new int[N];
    for(int i=0; i<N; i++)
      parents[i] = i;
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      if(answer == 0 && !union(v1, v2)) {
        answer = i+1;
        // break;
      }
    }
    System.out.println(answer);
  }
  private static boolean union(int a, int b) {
    int aRoot = find(a); // a의 root 노드
    int bRoot = find(b); // b의 root 노드
    // a와 b의 root 노드가 같다면 사이클 형성
    if(aRoot == bRoot) return false;
    parents[bRoot] = aRoot;
    return true;
}

private static int find(int n) {
    if(n == parents[n]) return n;
    return parents[n] = find(parents[n]);
}
}
