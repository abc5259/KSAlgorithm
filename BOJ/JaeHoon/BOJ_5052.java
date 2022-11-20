package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5052 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    for(int t=0; t<T; t++) {
      int N = Integer.parseInt(br.readLine());
      String[] numbers = new String[N];
      for(int i=0; i<N; i++) {
        numbers[i] = br.readLine();
      }
      Arrays.sort(numbers);
      boolean check = false;
      for(int i=0; i<N-1; i++) {
        if(check) break;
        if(numbers[i+1].startsWith(numbers[i])) {
          sb.append("NO").append("\n");
          check = true;
        }
      }
      if(!check) sb.append("YES").append("\n");
    }
    System.out.println(sb);
  }
}
