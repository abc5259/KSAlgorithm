package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1014 {
  static char[][] map;
  static int N,M;
  static long result;
  static class Seat {
    int bit, cnt;
    public Seat(int bit, int cnt) {
      this.bit = bit;
      this.cnt = cnt;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int C = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();

    while (C-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      map = new char[N+1][M];
      for(int i=1; i<=N; i++) {
        String s = br.readLine();
        for(int j=0; j<M; j++) {
          map[i][j] = s.charAt(j);
        } 
      }
      
      List<Seat> seats = new ArrayList<>();
      for(int bit=0; bit<1<<M; bit++) {
        if(checkSeat(bit)) {
          int cnt = 0;
          for(int i=0; i<M; i++) {
            int v = 1<<i;
            if((bit & v) == v) {
              cnt++;
            }
          }
          seats.add(new Seat(bit, cnt));
        }
      }

      int[][] dp = new int[N+1][1<<M];

      
      for(int i=1; i<=N; i++) {
        for(Seat seat: seats) {
          if(!check(i, seat.bit)) continue;
          for(Seat fSeat: seats) {
            if(!check(seat, fSeat)) continue;
            dp[i][seat.bit] = Math.max(dp[i][seat.bit], dp[i-1][fSeat.bit] + seat.cnt);
            result = Math.max(result, dp[i][seat.bit]);
          }
        }
      }


      sb.append(result).append('\n');
      result = 0;
    }
    System.out.print(sb);

  }

  public static boolean checkSeat(int bit) {
    for(int i=0; i<M-1; i++) {
      int v = 3<<i;
      if((bit & v) == v)  {
        return false;
      }
    }
    return true;
  }

  public static boolean check(Seat seat, Seat fSeat) {
    for(int i=0; i<M; i++) {
      int v = 1<<i;
      if((fSeat.bit & v) == v) { // 앞좌석에 사람이 앉아있음 
        if(i > 0 && (seat.bit & (1<<i-1)) >= 1) return false;
        if(i < M && (seat.bit & (1<<i+1)) >= 1) return false;
      }
    }
    return true;
  }

  public static boolean check(int n, int bit) {
    for(int j=0; j<M; j++) {
      if(map[n][j] == 'x') {
        int v = 1<<(j);
        if((bit & v) == v) {
          return false;
        }
      }
    }
    return true;
  }
}
