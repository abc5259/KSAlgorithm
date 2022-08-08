package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    String K = st.nextToken();
    int[] A = new int[N];
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(br.readLine());
    }
    int result = 0;
    int number = Integer.parseInt(K);
    for(int i = N-1; i >= 0; i--) {
      if(number == 0) break;
      if(number < A[i]) continue;
      int coinLength = number / A[i];
      result += coinLength;
      number -= A[i] * coinLength;
    }
    System.out.println(result);
  }
}
