package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9944 {
  static char[][] map;
  static boolean[][] isVisit;
  static int N,M;
  static int length;
  static int answer = 1000001;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    String ss = "";
    int t = 1;
    while((ss = br.readLine()) != null && !ss.isEmpty()) {
      StringTokenizer st = new StringTokenizer(ss);
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      map = new char[N][M];
      isVisit = new boolean[N][M];
      length = 0;
      for(int i=0; i<N; i++) {
        String s = br.readLine();
        for(int j=0; j<M; j++) {
          map[i][j] = s.charAt(j);
          if(map[i][j] == '.') length++;
        } 
      }
      for(int i=0; i<N; i++) {
         for(int j=0; j<M; j++) {
          if(map[i][j] == '.') {
            isVisit[i][j] = true;
            dfs(i, j, 1,0);
            isVisit[i][j] = false;
          }
        }
      }
      sb.append("Case " + t + ": ").append(answer == 1000001 ? -1 : answer).append("\n");
      t++;
      answer = 1000001;
    }
    System.out.println(sb);
  }

  public static void dfs(int x, int y, int cnt, int total) {
    if(length == cnt) {
      answer = Math.min(answer, total);
      return;
    }
    //동쪽
    int x1 = x;
    int y1 = y+1;
    int go = 0;
    while(y1 < M && !isVisit[x1][y1] && map[x1][y1] == '.') {
      go++;
      isVisit[x1][y1] = true;
      y1++;
    }
    if(go != 0) {
      dfs(x1, y1-1, cnt + go,total+1);
      for(int i=y1-1; i>y; i--) {
        isVisit[x1][i] = false;
      }
    }

    //서쪽
    int x2 = x;
    int y2 = y-1;
    go = 0;
    while(y2 >= 0  && !isVisit[x2][y2] && map[x2][y2] == '.') {
      go++;
      isVisit[x2][y2] = true;
      y2--;
    }
    if(go != 0) {
      dfs(x2, y2+1, cnt + go,total+1);
      for(int i=y2+1; i<y; i++) 
        isVisit[x2][i] = false;
    }

    //남쪽
    int x3 = x + 1;
    int y3 = y;
    go = 0;
    while(x3 < N && !isVisit[x3][y3] && map[x3][y3] == '.') {
      go++;
      isVisit[x3][y3] = true;
      x3++;
    }
    if(go != 0) {
      dfs(x3-1, y3, cnt + go,total+1);
      for(int i=x3-1; i>x; i--) 
        isVisit[i][y3] = false;
    }

    //북쪽
    int x4 = x - 1;
    int y4 = y;
    go = 0;
    while(x4 >= 0  && !isVisit[x4][y4] && map[x4][y4] == '.') {
      go++;
      isVisit[x4][y4] = true;
      x4--;
    }
    if(go != 0) {
      dfs(x4+1, y4, cnt + go,total+1);
      for(int i=x4+1; i<x; i++) 
        isVisit[i][y4] = false;
    }
  }
  static class Point {
    int x,y,cnt;
    Point(int x,int y) {
      this.x = x;
      this.y = y;
    }
  }
}
