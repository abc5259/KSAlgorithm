package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2263 {
  static StringBuffer sb = new StringBuffer();
  static int[] inorder;
  static int[] inorderIndex;
  static int[] postorder;
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    inorder = new int[n];
    postorder = new int[n];
    inorderIndex = new int[n+1];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      inorder[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      postorder[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=0; i<n; i++) {
      inorderIndex[inorder[i]] = i;
    }
    getPreOrder(0, n-1, 0, n-1);
    System.out.println(sb);
  }
  public static void getPreOrder(int in_start,int in_end,int p_start,int p_end) {
    if(in_start > in_end || p_start > p_end) {
      return;
    }

    int rootNode = postorder[p_end];
    sb.append(rootNode + " ");

    int rootIndex = inorderIndex[rootNode];
    int leftNodeLength = rootIndex - in_start;

    getPreOrder(in_start,rootIndex-1,p_start,p_start+leftNodeLength-1);

    getPreOrder(rootIndex+1, in_end, p_start+leftNodeLength, p_end-1);
  }
}
