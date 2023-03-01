package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3079 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());


    int time[] = new int[N];
    int max = 0;
    for(int i=0; i<N; i++) {
      time[i] = Integer.parseInt(br.readLine());
      max = Math.max(time[i], max);
    }

    long low = 0;
    long high = max * 1000000000L;

    while(low + 1 < high) {
      long mid = (low + high) / 2;
      
      long sum = 0;
      for(int i=0; i<N; i++) {
        if(sum >= M) break;
        sum += (mid / time[i]);
      }

      if(sum >= M) {
        high = mid;
      }else {
        low = mid;
      }
    }

    System.out.println(high);
  }
}
