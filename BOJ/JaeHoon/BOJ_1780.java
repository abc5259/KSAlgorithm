package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
  static int[][] map;
  static int N;
  static int[] answer = new int[3];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    map = new int[N+1][N+1];
    for(int i=1;i <=N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=1;j <=N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    if(!check(1, 1, N)) {
      solve(1,1,1,N);
    }else {
      answer[map[1][1] + 1] += 1;
    }
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<3; i++) {
      sb.append(answer[i]).append('\n');
    }
    System.out.println(sb);
  }
  public static void solve(int depth,int row, int col,int prevCnt) {
    int cnt = N / (int)Math.pow(3,depth);
    if(cnt < 1) {
      answer[map[row][col]+1] += 1;
      return;
    }else {
      for(int i=row; i<row+prevCnt; i+=cnt) {
        for(int j=col; j<col+prevCnt; j+=cnt) {
          if(!check(i, j, cnt)) {
            solve(depth+1, i, j,cnt);
          }else {
            answer[map[i][j]+1] += 1;
          }
        }
      }
    }
    
  }
  public static boolean check(int row,int col, int cnt) {
    int currNum = map[row][col];
    for(int i=row; i<row+cnt; i++) {
      for(int j=col; j<col+cnt; j++) {
        if(currNum != map[i][j]) return false;
      }
    }
    return true;
  }
}

// 9 등분할때 잘라야할 행/열 수  -> N / 3 (N이 3^k일때 가능)
// depth가 0일때 9*9
// depth가 1일때 3*3
// depth가 2일때 1*1
