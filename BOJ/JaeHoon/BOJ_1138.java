package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1138 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] result = new int[N];
    for(int i=0; i<N; i++) {
      int h = i + 1;
      int v = arr[i];

      int cnt = 0;
      for(int j=0; j<N; j++) {
        if(result[j] != 0) {
          continue;
        }
        if(cnt == v) {
          result[j] = h;
          break;
        }
        cnt++;
      }
    }

    StringBuffer sb = new StringBuffer();
    for(int i=0; i<N; i++) sb.append(result[i]).append(' ');
    System.out.println(sb);
  }
}
