package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
  static int N;
  static int[][] S;
  static boolean[] startTeam;
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = new int[N][N];
    startTeam = new boolean[N];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        S[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    solve(0,0);
    System.out.println(answer);
  } 
  public static void solve(int idx, int cnt) {
    if(cnt == N/2) {
      int startTeamSum = 0;
      int linkTeamSum = 0;
      for(int i=0; i<N-1; i++) {
        for(int j=i+1; j<N; j++) {
          if(startTeam[i] && startTeam[j]) {
            startTeamSum += S[i][j] + S[j][i];
          }
          if(!startTeam[i] && !startTeam[j]) {
            linkTeamSum += S[i][j] + S[j][i];
          }
        }
      }
      answer = Math.min(answer, Math.abs(linkTeamSum - startTeamSum));
      return;
    }
    
    for(int i=idx; i<N; i++) {
      if(!startTeam[i]) {
        startTeam[i] = true;
        solve(i+1, cnt+1);
        startTeam[i] = false;
      }
    }
  }
}