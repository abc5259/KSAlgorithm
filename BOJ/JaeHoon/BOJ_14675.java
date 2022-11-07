package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14675 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int N;
  static boolean[][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }
    StringBuffer sb = new StringBuffer();
    st = new StringTokenizer(br.readLine());
    int q = Integer.parseInt(st.nextToken());
    for(int i=0; i<q; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      if(t == 1) {
        sb.append(graph.get(k).size() > 1 ? "yes" : "no").append("\n");
      }else {
        sb.append("yes").append("\n");
      }
    }
    System.out.println(sb);
  }
}

