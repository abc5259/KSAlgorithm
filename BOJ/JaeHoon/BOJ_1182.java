package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_1182 {
  static int N;
  static int[] arr;
  static int s;
  static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    backTracking(0,0);
    if(s == 0) System.out.println(result-1);
    else System.out.println(result);
  }
  public static void backTracking(int depth,int sum) {
    if(depth == N) {
      if(sum == 0) result++;
      return;
    }
    backTracking(depth+1, sum+arr[depth]);
    backTracking(depth+1, sum);
  }
}
