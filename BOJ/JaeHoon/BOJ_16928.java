package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
  static int[] item = new int[101];
  static int[] board = new int[101];
  static boolean[] isVisit = new boolean[101];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    for(int i=0; i<N+M; i++) {
      st = new StringTokenizer(br.readLine());
      item[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }
    bfs(new Point(1, 0));
  }
  public static void bfs(Point start) {
    Queue<Point> q = new LinkedList<>();
    q.offer(start);
    isVisit[start.x] = true;
    while(!q.isEmpty()) {
      Point now = q.poll();
      if(now.x == 100) {
        System.out.println(now.cnt);
        System.exit(0);
      }
      for(int i=1; i<=6; i++) {
        int next = i + now.x;
        if(next < 1 || next > 100 || isVisit[next]) continue;
        isVisit[next] = true;
        if(item[next] == 0) {
          q.offer(new Point(next, now.cnt + 1));
        }else {
          if(!isVisit[item[next]]) {
            isVisit[item[next]] = true;
            q.offer(new Point(item[next], now.cnt+1));
          }
        }
      }
    }
  }
  public static class Point {
    int x;
    int cnt;
    Point(int x, int cnt) {
      this.x = x;
      this.cnt = cnt;
    }
  }
}
