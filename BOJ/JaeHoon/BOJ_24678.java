package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24678 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();

    for(int t=0; t<T; t++) {
      int[] arr = new int[3];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<3; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      int cnt = 0;
      if(arr[0] % 2 == 0) cnt++;
      if(arr[1] % 2 == 0) cnt++;
      if(arr[2] % 2 == 0) cnt++;

      if(cnt >= 2) sb.append("R");
      else sb.append("B");
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
