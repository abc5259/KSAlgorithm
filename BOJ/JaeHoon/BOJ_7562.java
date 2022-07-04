package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot {
  int x;
  int y;
  Dot(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class BOJ_7562 {
  static int[][] map;
  static int[] dx = {-1,-1,1,1,-2,-2,2,2};
  static int[] dy = {-2,2,-2,2,-1,1,-1,1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<T; i++) {
      int I = Integer.parseInt(br.readLine());
      map = new int[I][I];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      Dot dot = new Dot(v1, v2);
      st = new StringTokenizer(br.readLine());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());
      Dot endDot = new Dot(endX, endY);
      bfs(dot,I,endDot);
      sb.append((map[endDot.x][endDot.y])).append('\n');
    }
    System.out.print(sb);
  }
  public static void bfs(Dot dot,int I, Dot end) {
    Queue<Dot> queue = new LinkedList<>();
    queue.offer(dot);
    while(!queue.isEmpty()) {
      Dot d = queue.poll();
      if(d.x == end.x && d.y == end.y) {
        break;
      }
      for(int i=0; i<8; i++) {
        int x = d.x + dx[i];
        int y = d.y + dy[i];
        Dot dot2 = new Dot(x, y);
        if(x >=0 && x < I && y >=0 && y < I) {
          if(map[x][y] == 0) {
            queue.offer(dot2);
            map[x][y] = map[d.x][d.y] + 1;
          }
        }
      }
    }
  }
}

