package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2250 {
  public static class Node {
    int parent = -1;
    int value;
    Node left;
    Node right;
    Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  public static int row = 1;
  public static int level = 1;
  public static int[] levelMin;
  public static int[] levelMax;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    Node[] node = new Node[N+1];
    levelMin = new int[N+1];
    levelMax = new int[N+1];
    for(int i=1; i<=N; i++) {
      node[i] = new Node(i);
      levelMin[i] = i;
      levelMax[i] = 0;
    }
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int left = Integer.parseInt(st.nextToken());
      int right = Integer.parseInt(st.nextToken());
      if(left != -1) {
        node[v].left = node[left];
        node[v].left.parent = v;
      }
      if(right != -1) {
        node[v].right = node[right];
        node[v].right.parent = v;
      }
    }
    Node rootNode = node[1];
    for(int i=1; i<=N; i++) {
      if(node[i].parent == -1) {
        rootNode = node[i];
        break;
      }
    }
    inorder(rootNode,1);
    int resultLevel = 1;
    int resultDif = levelMax[1] - levelMin[1] + 1;
    for(int i=1; i<=level; i++) {
      int dif = levelMax[i] - levelMin[i] + 1;
      if(resultDif < dif) {
        resultDif = dif;
        resultLevel = i;
      }
    }
    System.out.println(resultLevel + " " + resultDif);
  }
  public static void inorder(Node node,int depth) {
    if(node.left != null) inorder(node.left,depth+1);
    level = Math.max(level, depth);
    levelMin[depth] = Math.min(row, levelMin[depth]);
    levelMax[depth] = row;
    row++;
    if(node.right != null) inorder(node.right,depth+1);
  }
}
