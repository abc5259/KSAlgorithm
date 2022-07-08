package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
  static int[] map = new int[100001];
  static int[] isVisit = new int[100001];
  static int[] dir = {2,1,-1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    bfs(new Point(N, 1), K);
    System.out.println(isVisit[K] - 1);
  }
  public static void bfs(Point start,int K) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(start);
    isVisit[start.x] = start.time;
    while(!queue.isEmpty()) {
      Point now = queue.poll();
      for(int i=0; i<3; i++) {
        int x = now.x;
        int time = now.time;
        if(i == 0) {
          x *= dir[i];
        }
        if(i == 1 || i == 2) {  
          x += dir[i];
          time++;
        }
        if(x < 0 || x > 100000) continue;
        if(isVisit[x] == 0 || isVisit[x] > time) {
          queue.offer(new Point(x, time));
          isVisit[x] = time;
        }
        
      }
    }
  }
  public static class Point{
    int x;
    int time;
    Point(int x, int time) {
      this.x = x;
      this.time = time;
    }
  }
}
