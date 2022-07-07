package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
  static boolean[] isVisit;
  static int[] dir = {1,-1,2};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    isVisit = new boolean[1000001];
    System.out.println(bfs(new Point(N, 0),K));
  }
  public static int bfs(Point start,int K) {
    Queue<Point> queue = new LinkedList<>();
    isVisit[start.x] = true;
    queue.offer(start);
    while(!queue.isEmpty()) {
      Point current = queue.poll();
      if(current.x == K) return current.cnt;
      int x1 = current.x + dir[0];
      int x2 = current.x + dir[1];
      int x3 = current.x * dir[2];
      if(x1 < 1000001 && x1 >=0) {
        if(!isVisit[x1]) {
          queue.offer(new Point(x1, current.cnt + 1));
          isVisit[x1] = true;
        }
      }
      if(x2 < 1000001 && x2 >=0) {
        if(!isVisit[x2]) {
          queue.offer(new Point(x2, current.cnt + 1));
          isVisit[x2] = true;
        }
      }
      if(x3 < 1000001 && x3 >=0) {
        if(!isVisit[x3]) {
          queue.offer(new Point(x3, current.cnt + 1));
          isVisit[x2] = true;
        }
      }
    }
    return 0;
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
