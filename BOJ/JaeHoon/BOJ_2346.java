package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2346 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());  
    int[] arr = new int[N];
    boolean[] isUsed = new boolean[N];

    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int cnt = 0;
    int removeIdx = 0;
    StringBuffer sb = new StringBuffer();
    while(cnt < N) {
      cnt++;
      int paper = arr[removeIdx];
      isUsed[removeIdx] = true;
      sb.append(removeIdx+1 + " ");
      if(paper > 0) { //종이가 양수라면 
        while(paper > 0 && cnt != N) {
          paper--;
          do {
            removeIdx++;
            if(removeIdx >= N) removeIdx = 0;
          }
          while(isUsed[removeIdx]);
          
        }

      }else { //종이가 음수라면
        while(paper < 0 && cnt != N) {
          paper++;
          do {
            removeIdx--;
            if(removeIdx < 0) removeIdx = N-1;
          }
          while(isUsed[removeIdx]);
        }
      }
    }
    System.out.println(sb);
  }
}
