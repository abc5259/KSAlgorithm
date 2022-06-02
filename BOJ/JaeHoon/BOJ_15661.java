package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15661 {
  static int N;
  static int[][] map;
  static boolean[] isUsed;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    isUsed = new boolean[N];
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // for(int i=1; i<N-1; i++) {
    //   func(0,0,i);
    // }
    solve(0);
    System.out.println(min);
  }
  public static void func(int start, int count,int end) {
    if(count == end) {
      diff();
      return;
    }
    for(int i=start; i<N; i++) {
      if(!isUsed[i]) {
        isUsed[i] = true;
        func(i+1,count+1,end);
        isUsed[i] = false;
      }
    }
  }
  public static void diff() {
    int team_start = 0;
    int team_link = 0;
    for(int i=0; i<N-1; i++) {
      for(int j=i+1; j<N; j++) {
        if(isUsed[i] == true && isUsed[j] == true) {
          team_start += map[i][j];
          team_start += map[j][i];
        }
        else if(isUsed[i] == false && isUsed[j] == false) {
          team_link += map[i][j];
          team_link += map[j][i];
        }
      }
    }
    min = Math.min(min, Math.abs(team_link - team_start));
  }
  public static void solve(int depth) {
    if (depth == N) {
        diff();
        System.out.println(Arrays.toString(isUsed));
        return;
    }
    isUsed[depth] = true;
    System.out.println("depth = " + depth + Arrays.toString(isUsed));
    solve(depth + 1);
    isUsed[depth] = false;
    System.out.println("return depth = " + depth + Arrays.toString(isUsed));
    solve(depth + 1);
    return;
  }
}
