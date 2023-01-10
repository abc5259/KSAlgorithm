package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14570 {
  static Node[] nodes;
  static class Node {
    int left,right;
    int leftCoin, rightCoin;
    Node(int left,int right) {
      this.left = left;
      this.right = right;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    nodes = new Node[N+1];
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int left = Integer.parseInt(st.nextToken());
      int right = Integer.parseInt(st.nextToken());
      nodes[i] = new Node(left, right);
    }
    long coins = Long.parseLong(br.readLine());
    System.out.println(dfs(1,coins));
  }
  public static int dfs(int node, long cnt) {
    // System.out.println("node = " + node);
    if(nodes[node].left == -1 && nodes[node].right == -1) {
      return node;
    }
    if(nodes[node].left == -1 && nodes[node].right != -1) {
      return dfs(nodes[node].right,cnt);
    }
    if(nodes[node].left != -1 && nodes[node].right == -1) {
      return dfs(nodes[node].left,cnt);
    }
    if(nodes[node].left != -1 && nodes[node].right != -1) {
      if(cnt % 2 == 1) {
        return dfs(nodes[node].left,cnt / 2 + 1);
      }else {
        return dfs(nodes[node].right,cnt /= 2);
      }
    }
    return -1;
  }
}
