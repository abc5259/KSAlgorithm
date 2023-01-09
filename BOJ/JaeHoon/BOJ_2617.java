package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2617 {
  static ArrayList<ArrayList<Integer>> bigGraph = new ArrayList<>();
  static ArrayList<ArrayList<Integer>> smallGraph = new ArrayList<>();
  static int[] bigerCntArr;
  static int[] smallCntArr;
  static boolean[] isVisit1, isVisit2;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    bigerCntArr = new int[N+1];
    smallCntArr = new int[N+1];
    for(int i=0; i<=N; i++) {
      bigGraph.add(new ArrayList<>());
      smallGraph.add(new ArrayList<>());
    }

    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int big = Integer.parseInt(st.nextToken());
      int small = Integer.parseInt(st.nextToken());
      bigGraph.get(small).add(big);
      smallGraph.get(big).add(small);
    }
    for(int i=1; i<=N; i++) {
      isVisit1 = new boolean[N+1];
      isVisit2 = new boolean[N+1];
      dfs(i);
      dfs2(i);
    }
    int mid = (N+1)/2;
    int answer = 0;
    // System.out.println(Arrays.toString(bigerCntArr));
    // System.out.println(Arrays.toString(smallCntArr));
    for(int i=1; i<=N; i++) {
      if(smallCntArr[i] >= mid || bigerCntArr[i] >= mid) {
        answer++;
      }
    }
    System.out.println(answer);
  }
  public static void dfs(int start) {
    isVisit1[start] = true;
    for(int next:bigGraph.get(start)) {
      if(!isVisit1[next]) {
        bigerCntArr[next]++;
        dfs(next);
      }
    }
  }
  public static void dfs2(int start) {
    isVisit2[start] = true;
    for(int next:smallGraph.get(start)) {
      if(!isVisit2[next]) {
        smallCntArr[next]++;
        dfs2(next);
      }
    }
  }
}
