package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String A = st.nextToken();
    String B = st.nextToken();
    int result = 1;
    while(!A.equals(B)) {
      if(Integer.parseInt(B) < Integer.parseInt(A)) break;
      if(Integer.parseInt(B) % 2 == 0) {
        B = String.valueOf(Integer.parseInt(B)/2);
        result++;
      }
      else if(B.charAt(B.length() - 1) == '1') {
        B = B.substring(0, B.length() - 1);
        result++;
      }else {
        break;
      }
    }
    System.out.println(A.equals(B) ? result : -1);
  }
}
