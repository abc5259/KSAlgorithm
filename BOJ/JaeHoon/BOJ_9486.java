package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9486 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      if(N == 0 && K == 0) break;

      st = new StringTokenizer(br.readLine());
      int kIdx = 1;

      int[] arr = new int[N+1];
      int[] parent = new int[N+1];
      arr[1] = Integer.parseInt(st.nextToken());
      parent[0] = -1;
      parent[1] = 0;
      int parentIdx = 0;
      for(int i=2; i<=N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        if(arr[i] == K) kIdx = i;

        if(arr[i-1] + 1 != arr[i]) { //연속된 숫자라면 
          parentIdx += 1;
        }
        parent[i] = parentIdx;
      }


      int answer = 0;
      for(int i=1; i<=N; i++) {
        if(parent[i] != parent[kIdx] && parent[parent[i]] == parent[parent[kIdx]]) {
          answer++;
        }
      }
      sb.append(answer+"\n");
    }
    System.out.println(sb);
  }
}
