package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1933 {
  static class Apart {
    int L,H,R;
    Apart(int L,int H,int R) {
      this.L = L;
      this.H = H;
      this.R = R;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    Apart[] aparts = new Apart[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int L = Integer.parseInt(st.nextToken());
      int H = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());
      aparts[i] = new Apart(L, H, R);
    }
  }
}
