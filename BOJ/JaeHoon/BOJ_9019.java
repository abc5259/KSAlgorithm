package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
  static boolean[] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      sb.append((bfs(new Point(start, ""), end))).append('\n');
    }
    System.out.print(sb);
  }

  public static String bfs(Point start, int end) {
    isVisit = new boolean[10000];
    Queue<Point> q = new LinkedList<>();
    q.offer(start);
    isVisit[start.n] = true;
    while(!q.isEmpty()) {
      Point now = q.poll();
      if(now.n == end) return now.output;
      for(int i=0; i<4; i++) {
        int next;
        switch (i) {
          case 0:
            next = command_D(now.n);
            if(isVisit[next]) break;
            isVisit[next] = true;
            q.offer(new Point(next, now.output+"D"));
            break;
          case 1:
            next = command_S(now.n);
            if(isVisit[next]) break;
            isVisit[next] = true;
            q.offer(new Point(next, now.output+"S"));
            break;
          case 2:
            next = command_L(now.n);
            if(isVisit[next]) break;
            isVisit[next] = true;
            q.offer(new Point(next, now.output+"L"));
            break;
          case 3:
            next = command_R(now.n);
            if(isVisit[next]) break;
            isVisit[next] = true;
            q.offer(new Point(next, now.output+"R"));
            break;
        }
      }
    }
    return "";
  }

  public static int command_D(int n) {
    int result = n * 2;
    if(result > 9999)
      result %= 10000;
    return result;
  }

  public static int command_S(int n) {
    if(n == 0) return 9999;
    int result = n - 1;
    return result;
  }

  public static int command_L(int n) {
    int d1 = n / 1000;
    int d2 = n % 1000 / 100;
    int d3 = n % 1000 % 100 / 10;
    int d4 = n % 1000 % 100 % 10;
    int result = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
    return result;
  }

  public static int command_R(int n) {
    int d1 = n / 1000;
    int d2 = n % 1000 / 100;
    int d3 = n % 1000 % 100 / 10;
    int d4 = n % 1000 % 100 % 10;
    int result = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
    return result;
  }

  public static class Point {
    int n;
    String output;
    Point(int n, String output) {
      this.n = n;
      this.output = output;
    }
  }
}
