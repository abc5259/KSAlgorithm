package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1477 {
  static int N;
  static int M;
  static int[] dists;
  static int L;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());


    st = new StringTokenizer(br.readLine());
    dists = new int[N];
    for(int i=0; i<N; i++) {
      int dist = Integer.parseInt(st.nextToken());
      dists[i] = dist;
    }
    Arrays.sort(dists);
    
    
    int low = 0;
    int high = L;

    while(low + 1 < high) {
      int mid = (low + high) / 2;
      if(check(mid)) {
        high = mid;
      }else {
        low = mid;
      }
    }
    System.out.println(high);
  }
  public static boolean check(int maxDist) {
    int addCnt = 0;
    int prev = 0;
    int i = 0;
    while(true) {
      if(i == N) { //마지막 휴게소까지 왔다면 
        if(L - prev > maxDist) { // 고속도로 마지막까지의 거리가 maxDist보다 큰경우
          addCnt++; // 휴게소 설치
          prev += maxDist; // 설치한 휴게소까지 가기 
        }else {
          break;
        }
      }else {
        if(dists[i] - prev > maxDist) { // 다음에 갈 휴게소까지의 거리가 maxDist보다 큰경우
          addCnt++; // 휴게소 설치
          prev += maxDist; // 설치한 휴게소까지 가기 
        }else { // 다음 휴게소까지 갈 수 있는 거리라면
          prev = dists[i++]; // 다음 휴게소로 가기 
        }
      }
    }

    if(addCnt > M) return false;
    return true;
  }
}
