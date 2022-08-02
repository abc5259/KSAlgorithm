package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16933 {
  //밤 낮 같은 칸에서 밤인지 낮인지.. 밤이면 다음칸 갈때 낮을로 바뀌는데 다음칸이 벽이면 갈 수 있음
  // 낮인데 다음칸이 벽일때 못감 왜? 벽은 낮에만 갈 수 있거든
  // 그러니깐 낮인지 밤인지 채크해주는 필드를 하나 만들어주고..
  // isVisit 배열에 낮 밤 인지 상태까지 추가?? 흠
  static int N;
  static int M;
  static int K;
  static int[][] map;
  static boolean[][][][] isVisit;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    // 0이면 낮 1이면 밤
    isVisit = new boolean[N][M][K+1][2];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j) - '0';
      }
    }
    System.out.println(bfs(new Point(0, 0, 1, 0, 1))); 
  }
  public static int bfs(Point start) {
    Queue<Point> q = new ArrayDeque<>();
    q.offer(start);
    isVisit[start.x][start.y][0][0] = true;
    while(!q.isEmpty()) {
      Point now = q.poll();
      if(now.x == N-1 && now.y == M-1) return now.cnt;
      for(int i=0; i<4; i++) {
        int nx = now.x + dir[i][0];
        int ny = now.y + dir[i][1];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(map[nx][ny] == 0)  {
          // 다음에 가는 곳이 벽이 없는 곳이라면 
          if(isVisit[nx][ny][now.breakWallCnt][1 - now.isSun]) continue;
          isVisit[nx][ny][now.breakWallCnt][1 - now.isSun] = true;
          q.offer(new Point(nx, ny, now.cnt+1, now.breakWallCnt, 1 - now.isSun));
        }else {
          // 다음에 가는 곳이 벽이라면 

          // 벽을 부순 횟수가 K번을 넘었거나 
          // 이미 방문한 곳이라면 continue
          // 지금 밤이면 하루기다렸다가 가야함
          if(now.isSun == 0) {
            if(now.breakWallCnt + 1 > K || isVisit[now.x][now.y][now.breakWallCnt][1- now.isSun]) continue;
            isVisit[now.x][now.y][now.breakWallCnt][1- now.isSun] = true;
            q.offer(new Point(now.x, now.y, now.cnt+1, now.breakWallCnt, 1 - now.isSun));
          }else {
            //지금 낮이면 바로 부수고 가도됨
            if(now.breakWallCnt + 1 > K || isVisit[nx][ny][now.breakWallCnt+1][1 - now.isSun]) continue;
            isVisit[nx][ny][now.breakWallCnt+1][1 - now.isSun] = true;
            q.offer(new Point(nx, ny, now.cnt+1, now.breakWallCnt+1, 1 - now.isSun));
          }
        }
      }
    }
    return -1;
  }
  public static class Point {
    int x,y,breakWallCnt,cnt;
    int isSun;
    Point(int x, int y, int cnt,int breakWallCnt, int isSun) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.breakWallCnt = breakWallCnt;
      this.isSun = isSun;
    }
  }
}
