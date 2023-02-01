package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6209 {
  static int d,n,m;
  static int[] stoneArr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    d = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    stoneArr = new int[n+2];
    for(int i=1; i<=n; i++) {
      stoneArr[i] = Integer.parseInt(br.readLine());
    }
    stoneArr[n+1] = d;
    Arrays.sort(stoneArr);
    
    int low = 0;
    int high = d+1;

    while(low + 1 < high) {
      int mid = (low+high) / 2;
      if(check(mid)) {
        low = mid;
      }else {
        high = mid;
      }
    }
    System.out.println(low);

  }
  public static boolean check(int minJumpDist) {
    if(n > 0 && stoneArr[n+1] - stoneArr[n] < minJumpDist) return false;
    int removeStoneCnt = 0;
    int i = 0;
    while(i < n) {
      int currIdx = i;
      int nextIdx = i+1;
      while(nextIdx <= n && stoneArr[nextIdx] - stoneArr[currIdx] < minJumpDist) {
        nextIdx++;
        removeStoneCnt++; // 돌 제거 갯수 카운트 + 1
        if(removeStoneCnt > m) return false;
      }
      i = nextIdx;
    }
    if(removeStoneCnt > m) return false;
    return true;
  }
}
