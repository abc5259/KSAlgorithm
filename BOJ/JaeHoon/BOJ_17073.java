package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17073 {
  static class Node {
    int v,w;
    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
  static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
  static int N,W;
  static boolean[] isVisit;
  static int pCnt = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    isVisit = new boolean[N+1];
    for(int i=0; i<=N; i++) {
      tree.add(new ArrayList<>());
    }

    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      tree.get(u).add(new Node(v, 0));
      tree.get(v).add(new Node(u, 0));
    }

    dfs(1, W);
    BigDecimal valueA = new BigDecimal(W);
    BigDecimal valueB = new BigDecimal(pCnt);
    BigDecimal divideValue = valueA.divide(valueB,MathContext.DECIMAL64);
    System.out.println(divideValue);
  }
  public static void dfs(int nodeIdx, int water) {
    isVisit[nodeIdx] = true;

    int childCnt = 0;
    for(Node child: tree.get(nodeIdx)) {
      if(!isVisit[child.v]) childCnt++;
    }

    if(childCnt == 0) {
      pCnt++;
      return;
    }

    int avgWater = water / childCnt;
    int restWater = water % childCnt;

    for(Node child: tree.get(nodeIdx)) {
      if(isVisit[child.v]) continue;
      dfs(child.v, avgWater + restWater);
      if(restWater != 0) restWater--;
    }
  }
}