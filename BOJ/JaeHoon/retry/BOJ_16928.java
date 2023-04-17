package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
  static int[] items;
  static boolean[] isVisited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    items = new int[101];
    isVisited = new boolean[101];

    for(int i=0; i<N+M; i++) {
      st = new StringTokenizer(br.readLine());
      items[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }

    System.out.println(bfs());
  }
  public static int bfs() {
    Queue<Integer> q = new LinkedList<>();
    isVisited[1] = true;
    q.offer(1);

    int cnt = 0;
    while(!q.isEmpty()) {
      

      cnt++;

      int size = q.size();
      while(size-- > 0) {
        int curr = q.poll();
        for(int i=1; i<=6; i++) {
          int next = i + curr;
  
          if(next > 100 || isVisited[next]) continue;
          
          if(next == 100) return cnt;
          isVisited[next] = true;
          if(items[next] == 0) {
            q.offer(next);
          }else {
            if(isVisited[items[next]]) continue;
            isVisited[items[next]] = true;
            q.offer(items[next]);
          }
        }
      }
    }
    
    return -1;
  }
}
