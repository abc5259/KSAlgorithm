package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3653 {
  static int[] index;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int total = N+M;
      index = new int[N+1];
      arr = new int[total];
      int num = 1;
      for(int i=M; i<total; i++) {
        index[num] = i;
        arr[i] = 1;
        num++;
      }

      Segment segment = new Segment(N+M);
      segment.init(1, 0, N+M-1);
      
      st = new StringTokenizer(br.readLine());
      int cur = M-1;
      for(int i=0; i<M; i++) {
        int v = Integer.parseInt(st.nextToken());
        int pos = index[v];
        long cnt = segment.sum(1, 0, total-1, 0, pos-1);
        sb.append(cnt).append(" ");
        segment.update(1, 0, total-1, pos, -1);
        segment.update(1, 0, total-1, cur, 1);
        index[v] = cur;
        cur--;
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
  static class Segment {
    long tree[];
    int treeSize;

    public Segment(int n) {
      int k = (int) Math.ceil(Math.log(n) / Math.log(2));
      int height = k + 1;
      int size = (int) Math.pow(2, height);
      tree = new long[size];
      this.treeSize = size;
    }
    
    public long init(int node, int start, int end) {
      if(start == end) {
        return tree[node] = arr[start];
      }

      return tree[node] = 
        init(node*2, start, (start+end)/2) 
        + init(node*2+1, (start+end)/2+1, end);
    }

    public void update(int node, int start, int end, int idx, long diff) {
      if(idx < start || end < idx) return;

      tree[node] += diff;

      if(start != end) {
        update(node*2, start, (start+end)/2, idx, diff);
        update(node*2+1, (start+end)/2+1, end, idx, diff);
      }
    }

    public long sum(int node, int start, int end, int left, int right) {
      if(left > end || right < start) {
        return 0;
      }

      if(left <= start && end <= right) {
        return tree[node];
      }

      return sum(node*2, start, (start+end)/2, left, right) +
              sum(node*2+1, (start+end)/2+1, end, left, right);
    }
  }
}
