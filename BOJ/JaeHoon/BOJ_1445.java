package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1445 {
  static int N, M;
  static char[][] map;
  static Trash[][] dp;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {1,-1,0,0};
  static int[] end;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    dp = new Trash[N][M];
    int[] start = new int[2];
    end = new int[2];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j);
        if(map[i][j] == 'S') {
          start[0] = i;
          start[1] = j;
        }
        else if(map[i][j] == 'F') {
          end[0] = i;
          end[1] = j;
        }
      }
    }

  
    // dp[start[0]][start[1]] = new Trash(start[0], start[1], 0, 0);
    solve(start[0], start[1]);

    System.out.println(dp[end[0]][end[1]].cnt + " " + dp[end[0]][end[1]].side);
  }

  public static void solve(int x, int y) {
    Queue<Trash> pq = new PriorityQueue<>((a,b) -> {
      if(a.cnt == b.cnt) return a.side - b.side;
      return a.cnt - b.cnt;
    });
    pq.offer(new Trash(x,y,0,0));
    while (!pq.isEmpty()) {
      Trash cur = pq.poll();

      if(dp[cur.x][cur.y] != null) {
        if(dp[cur.x][cur.y].cnt < cur.cnt) continue;
        if(dp[cur.x][cur.y].cnt == cur.cnt && dp[cur.x][cur.y].side <= cur.side) continue;
      }

      dp[cur.x][cur.y] = cur;

      if(cur.x == end[0] && cur.y == end[1]) {return;}
    
      for(int d = 0; d< 4; d++) {
        int nx = cur.x + dx[d];
        int ny = cur.y + dy[d];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

        int trashCnt = map[nx][ny] == 'g' ? cur.cnt + 1 : cur.cnt;
        int total = map[nx][ny] == '.' ? cur.side + getSideTrashCnt(nx, ny) : cur.side;
        // if(dp[nx][ny] != null) {
        //   if(dp[nx][ny].cnt < trashCnt) continue;
        //   if(dp[nx][ny].cnt == trashCnt) {
        //     if(dp[nx][ny].side <= total) continue;
        //   }
        // }
        // else dp[nx][ny] = new Trash(nx, ny, trashCnt, total);

        // dp[nx][ny].cnt = trashCnt;
        // dp[nx][ny].side = total;
        // if(nx == end[0] && ny == end[1]) {
        //   return;
        // }
        pq.offer(new Trash(nx, ny, trashCnt, total));
      }
    }
  }

  public static int getSideTrashCnt(int x, int y) {
    for(int i=0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      if(map[nx][ny] == 'g') return 1;
    }
    return 0;
  }

  static class Trash {
    int x,y,cnt, side;
    public Trash(int x, int y, int cnt, int side) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.side = side;
    }
  }
}
