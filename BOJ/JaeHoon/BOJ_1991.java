package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
  public static class Node {
    char value;
    Node left;
    Node right;
    Node(char value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
    public void addLeft(Node left) {
      this.left = left;
    }
    public void addRight(Node right) {
      this.right = right;
    }
  }
  static Node[] nodeArr;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    nodeArr = new Node[N];
    char nodeValue = 'A';
    for(int i=0; i<N; i++) nodeArr[i] = new Node(nodeValue++);
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int index = st.nextToken().charAt(0) - 'A';
      char left = st.nextToken().charAt(0);
      char right = st.nextToken().charAt(0);
      nodeArr[index].left = left == '.' ? null : nodeArr[left - 'A'];
      nodeArr[index].right = right == '.' ? null : nodeArr[right - 'A'];
    }
    preorder(nodeArr[0]);
    sb.append('\n');
    inorder(nodeArr[0]);
    sb.append('\n');
    postorder(nodeArr[0]);
    System.out.println(sb);
  }
  public static void preorder(Node node) {
    sb.append(node.value);
    if(node.left != null) preorder(node.left);
    if(node.right != null) preorder(node.right);
  }
  public static void inorder(Node node) {
    if(node.left != null) inorder(node.left);
    sb.append(node.value);
    if(node.right != null) inorder(node.right);
  }
  public static void postorder(Node node) {
    if(node.left != null) postorder(node.left);
    if(node.right != null) postorder(node.right);
    sb.append(node.value);
  }
}
