package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12846 {
  static int[] tree;
  static int N;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    tree = new int[4*N];
    init(1, N, 1);

    System.out.println(solve(1, N));
  }

  public static void init(int l, int r, int node) {
    if(l == r) {
      tree[node] = l;
      return;
    }

    int mid = (l + r) / 2;
    init(l, mid, node*2);
    init(mid+1, r, node*2+1);

    if(arr[tree[node*2]] < arr[tree[node*2+1]]) {
      tree[node] = tree[node*2];
    }else {
      tree[node] = tree[node*2+1];
    }
  }

  public static int query(int s, int e, int node, int l, int r) {
    if(r < s || e < l)  return -1;
    if(l <= s && e <= r) {
      return tree[node];
    }

    int mid = (s+e)/2;
    int lNode = query(s, mid, node*2, l, r);
    int rNode = query(mid+1, e, node*2+1, l, r);

    if(lNode == -1) {
      return rNode;
    }
    if(rNode == -1) {
      return lNode;
    }

    if(arr[lNode] < arr[rNode]) {
      return lNode;
    }
    return rNode;
  }

  public static long solve(int l, int r) {
    int m = query(1, N, 1, l, r);

    long answer = (long)(r - l + 1) * arr[m];

    if(l <= m - 1) {
      answer = Math.max(solve(l, m-1), answer);
    }
    if(m+1 <= r) {
      answer = Math.max(solve(m+1, r), answer);
    }

    return answer;
  }
}
