package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2812 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    String strNum = br.readLine();
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    boolean[] isRemove = new boolean[N];

    for(int i=0; i<N-1; i++) {
      int n = strNum.charAt(i) - '0';
      int nextN = strNum.charAt(i+1) - '0';
      if(n < nextN) {
        pq.offer(i);
      }
    }
    int removeCnt = 0;
    while(!pq.isEmpty()) {
      int idx = pq.poll();
      isRemove[idx] = true;
      removeCnt++;

      if(removeCnt == K) break;
      if(idx - 1 >= 0) {

        int prevIdx = idx -1;
        int nextIdx = idx + 1;

        while(prevIdx >= 0 && isRemove[prevIdx]) {
          prevIdx--;
        }

        while(nextIdx < N && isRemove[nextIdx]) {
          nextIdx++;
        }

        if(prevIdx >= 0 && nextIdx < N) {
          if(strNum.charAt(prevIdx) - '0' < strNum.charAt(nextIdx) - '0') {
            pq.offer(prevIdx);
          }
        }

      }
    }

    if(removeCnt < K) {
      for(int i=N-1; i>=0; i--) {
        if(!isRemove[i]) {
          isRemove[i] = true;
          removeCnt++;

          if(removeCnt == K) break;
        }
      }
    }
    StringBuffer sb = new StringBuffer(N-K);
    for(int i=0; i<N; i++) {
      if(!isRemove[i]) {
        sb.append(strNum.charAt(i));
      }
    }
    System.out.println(sb);
  }
}
