package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14575 {
  static int N,T;
  static People[] peoples;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    peoples = new People[N];
    int low_sum = 0;
    int high_sum = 0;
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE; 
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      peoples[i] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      low_sum += peoples[i].L;
      high_sum += peoples[i].R;
      low = Math.min(low,peoples[i].L);
      high = Math.max(high,peoples[i].R);
    }
    low--;
    high++;
    if(low_sum > T || high_sum < T) {
      System.out.println(-1);
    }else {
      while(low +1< high) {
        int mid = (low + high) / 2;
        if(check(mid)) {
          high = mid;
        }else {
          low = mid;
        }
      }
      System.out.println(high);
    }


  }
  public static boolean check(int S) {
    int sum = 0;
    int more = 0;
    for(int i=0; i<N; i++) {
      if(peoples[i].L > S) return false;
      sum += peoples[i].L;
      more += Math.min(S - peoples[i].L, peoples[i].R - peoples[i].L);
    }
    if(T - sum <= more) return true;
    return false;
  }
  static class People {
    int L,R;
    People(int L, int R) {
      this.L = L;
      this.R = R;
    }
  }
}
