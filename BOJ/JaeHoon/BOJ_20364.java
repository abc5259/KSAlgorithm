package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20364 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    boolean[] isVisit = new boolean[N+1];
    int[] docks = new int[Q];
    for(int i=0; i<Q; i++) {
      docks[i] = Integer.parseInt(br.readLine());
    }
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<Q; i++) {
      int parent = docks[i];
      boolean isOk = true;
      int minParent = docks[i];
      while(parent >= 1) {
        // System.out.println(parent);
        if(isVisit[parent]) {
          minParent = parent;
          isOk = false;
        }
        parent /= 2;
      }
      if(isOk) {
        isVisit[docks[i]] = true;
        sb.append(0).append('\n');
      }else {
        sb.append(minParent).append('\n');
      }
    }
    System.out.println(sb);
  }
}
