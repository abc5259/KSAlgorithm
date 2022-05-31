package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
  static int N;
  static int[][] S;
  static boolean[] isUsed;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    S = new int[N][N];
    isUsed = new boolean[N];
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        S[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    func(0,0);
    System.out.println(min);
  }
  public static void func(int index,int count) {
    if(count == N/2) {
      diff();
      return;
    }
    for(int i=index; i<N; i++) {
      if(!isUsed[i]) {
        isUsed[i] = true;
        func(index+1,count+1);
        isUsed[i] = false;
      }
    }
  }
  public static void diff() {
    int team_start = 0;
		int team_link = 0;
    for (int i = 0; i < N-1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (isUsed[i] == true && isUsed[j] == true) {
          team_start += S[i][j];
          team_start += S[j][i];
        }
        else if (isUsed[i] == false && isUsed[j] == false) {
          team_link += S[i][j];
          team_link += S[j][i];
        }
      }
    }
    min = Math.min(min, Math.abs(team_link - team_start));
  }
}
