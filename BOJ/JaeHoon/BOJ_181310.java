package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_181310 {
  static int N;
  static int[] home;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    home = new int[N];
    
    for(int i=0; i<N; i++) {
      home[i] = Integer.parseInt(st.nextToken());
    } 

    Arrays.sort(home);
    int leftCnt = 0;
    int rightCnt = N;
    long dist = 0;
    for(int i=1; i<N; i++) {
      dist += Math.abs(home[i] - home[0]);
    }
    int homeIndx = 0;
    long minDist = dist;
    int answer = 1;
    for(int x=2; x<=home[N-1]; x++) {
      while(x > home[homeIndx]) {
        leftCnt++;
        homeIndx++;
        rightCnt--;
      }
      dist = dist + leftCnt - rightCnt;
      if(dist < minDist) {
        answer = x;
        minDist = dist;
      }
    }
    System.out.println(answer);
  }
}
