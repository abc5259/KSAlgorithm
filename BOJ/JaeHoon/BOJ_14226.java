package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {
  static boolean[][] isVisit = new boolean[1001][1001];
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int S = Integer.parseInt(br.readLine());
    System.out.println(bfs(S));
  }
  public static int bfs(int S) {
    Queue<Emoji> queue = new LinkedList<>();
    queue.offer(new Emoji(1,0,0));
    isVisit[1][0] = true;
    while(!queue.isEmpty()) {
      Emoji now = queue.poll();
      for(int i=0; i<3; i++) {
        int cnt = now.cnt;
        int time = now.time;
        int clipBoard = now.clipBoard;
        if(i == 0) {
          cnt -= 1;
          time++;
        }
        if(i == 1) {
          clipBoard = cnt;
          time++;
        }
        if(i == 2) {
          if(clipBoard == 0) continue;
          cnt += clipBoard;
          time++;
        }
        if(cnt < 0 || cnt > 1000 || isVisit[cnt][clipBoard]) continue;
        if(cnt == S) return time;
        queue.offer(new Emoji(cnt, time,clipBoard));
        isVisit[cnt][clipBoard] = true;
      }
    }
    return 0;
  }
  public static class Emoji {
    int cnt;
    int time;
    int clipBoard;
    Emoji(int cnt, int time,int clipBoard) {
      this.cnt = cnt;
      this.time = time;
      this.clipBoard = clipBoard;
    }
  }
}
 