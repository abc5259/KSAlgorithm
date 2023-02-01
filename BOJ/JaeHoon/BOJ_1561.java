package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1561 {
  static int N, M;
  static int[] rides;
  static boolean answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    rides = new int[M+1];

    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=M; i++) {
      rides[i] = Integer.parseInt(st.nextToken());
    }

    if(N <= M) {
      System.out.println(N);
    }else {
      long low = 0;
      long high = 2000000000000000L;
      int sout = -1;
      while(low + 1 < high) {
        long mid = (low+high) / 2;
        int result = check(mid);
        if(answer) {
          sout = result;
          break;
        }
        else if(result > 0) {
          high = mid;
        }
        else {
          low = mid;
        }
      }
      System.out.println(sout);
    }
  }
  public static int check(long n) {
    long rideChildCnt = 0;
    int[] currRideAbleIdx = new int[M+1];
    int addCnt = 0;
    
    for(int i=1; i<=M; i++) {
      rideChildCnt += (n-1) / rides[i] + 1;
      if(n % rides[i] == 0) {
        currRideAbleIdx[i] = 1;
        addCnt++;
      }
    }
  
    if(rideChildCnt >= N) return 1;
    if(rideChildCnt + addCnt < N) return -1;
    for(int i=1; i<=M; i++) {
      if(currRideAbleIdx[i] == 1) rideChildCnt++;
      if(rideChildCnt == N) {
        answer = true;
        return i;
      }
    }
    return 0;
  }
}
