package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
  static int[] lectures;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    lectures = new int[N];
    st = new StringTokenizer(br.readLine());
    int low = Integer.MAX_VALUE;
    int high = 0;
    for(int i=0; i<N; i++) {
      lectures[i] = Integer.parseInt(st.nextToken());
      low = Math.min(lectures[i], low);
      high += lectures[i];
    }

    while(low <= high) {
      int middle = (low+high)/2;
      if(check(middle) > M) {
        low = middle + 1;
      }else {
        high = middle - 1;
      }
    }
    System.out.println(low);
  }
  public static int check(int length) {
    int sum = 0;
    int cnt = 0;
    for(int i=0; i<lectures.length; i++) {
      if(sum + lectures[i] > length) {
        sum = 0;
        cnt++;
      }
      sum += lectures[i];
    }
    if(sum != 0) cnt++;
    // System.out.println("length = " + length + " cnt = " + cnt);
    return cnt;
    // if(cnt != M) 
    //   return false;
    // return true;
  }
}
