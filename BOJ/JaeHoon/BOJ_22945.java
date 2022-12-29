package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22945 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] developments = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      developments[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0;
    int end = N-1;
    int answer = 0;
    while(start != end) {
      answer = Math.max(answer, Math.min(developments[start], developments[end]) * (end - start - 1));
      if(developments[start] <= developments[end])
        start++;
      else end--;
    }
    System.out.println(answer);
  }
}
