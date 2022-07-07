package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {
  static int[] dir = {-1,1,2};
  static boolean[] isVisit = new boolean[100001];
  static int[] parent = new int[100001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int p = bfs(new Point(N, 0), K);
    Stack<Integer> stack = new Stack<>();
    stack.push(K);
    int index = K;
    while(index != N) {
      stack.push(parent[index]);
      index = parent[index];
    }
    sb.append(p).append('\n');
    while(!stack.isEmpty()) {
      sb.append(stack.pop()).append(' ');
    }
    System.out.println(sb);
  }
  public static int bfs(Point start,int K) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(start);
    isVisit[start.x] = true;
    while(!queue.isEmpty()) {
      Point current = queue.poll();
      if (current.x == K) return current.cnt;
      for(int i=0; i<3; i++) {
        int x = current.x;
        if(i == 0 || i == 1) x += dir[i];
        if(i == 2) x *= dir[i];
        if(x < 0 || x >= 100001 || isVisit[x]) continue;
        queue.offer(new Point(x, current.cnt + 1));
        isVisit[x] = true;
        parent[x] = current.x;
      }
    }
    return 0;
  }
  public static class Point {
    int x;
    int cnt;
    Point(int x,int cnt) {
      this.x = x;
      this.cnt = cnt;
    }
  }
}
