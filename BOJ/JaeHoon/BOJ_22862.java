package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_22862 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] evenSum = new int[N+1];
    int[] oddSum = new int[N+1];
    ArrayList<Integer> evenIndex = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    boolean isEven = false;
    for(int i=1; i<=N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if(num % 2 == 0) {
        evenSum[i] += evenSum[i-1] + 1;
        oddSum[i] += oddSum[i-1];
        if(!isEven) evenIndex.add(i);
        isEven = true;
      }else {
        isEven = false;
        oddSum[i] += oddSum[i-1] + 1;
        evenSum[i] += evenSum[i-1];
      }
    }
    // System.out.println(evenIndex);
    int max = 0;
    if(evenIndex.size() > 0) {
      int start = evenIndex.get(0), end = evenIndex.get(0), index = 0;
      while(end <= N) {
        if(oddSum[end] - oddSum[start] > K) {
          max = Math.max(max, evenSum[end]-evenSum[start-1]);
          start = evenIndex.get(++index);
        }
        else {
          max = Math.max(max, evenSum[end]-evenSum[start-1]);
          end++;
          
        }
      }
    }
    
    System.out.println(max);
  }
}
