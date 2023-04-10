package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
  static int[] items;
  static int N, M;
  static boolean[] isVisited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    items = new int[101];
    isVisited = new boolean[101];

    for(int i=0; i<N+M; i++) {
      st = new StringTokenizer(br.readLine());
      items[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }

    System.out.println(bfs());
  }
  public static int bfs() {
    Queue<int[]> q = new LinkedList<>();
    isVisited[1] = true;
    q.offer(new int[]{1,0});

    while(!q.isEmpty()) {
      int[] curr = q.poll();
      if(curr[0] == 100) {
        return curr[1];
      }

      for(int i=1; i<=6; i++) {
        int next = i + curr[0];

        if(next > 100 || isVisited[next]) continue;

        isVisited[next] = true;
        if(items[next] == 0) {
          q.offer(new int[]{next,curr[1]+1});
        }else {
          if(isVisited[items[next]]) continue;
          isVisited[items[next]] = true;
          q.offer(new int[]{items[next],curr[1]+1});
        }
      }
    }
    
    return -1;
  }
}
