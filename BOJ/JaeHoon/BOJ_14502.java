package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
  static int[][] map;
  static int N;
  static int M;
  static int[][] dir = {{1,0},{-1,0}, {0,-1}, {0,1}};
  static ArrayList<Virus> virusArr = new ArrayList<>();
  static int result = Integer.MIN_VALUE;
  // dfs로 벽 3개를 선택한 후에 bfs로 알아보기
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 2) 
          virusArr.add(new Virus(i, j));
      }
    }
    dfs(0);
    System.out.println(result);
  }

  public static void dfs(int depth) {
    if(depth == 3) {
      result = Math.max(result,bfs());
      // System.out.println();
      return;
    }
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map[i][j] != 0) continue;
        map[i][j] = 1;
        dfs(depth+1);
        map[i][j] = 0;
      }
    }
  }

  public static int bfs() {
    Queue<Virus> q = new LinkedList<>();
    int[][] copyMap = new int[N][M];
    for(int i=0; i<N; i++) {
      copyMap[i] = map[i].clone();
    }
    for(int i=0; i<virusArr.size(); i++) {
      Virus v = virusArr.get(i);
      q.offer(v);
    }
    while(!q.isEmpty()) {
      Virus now = q.poll();
      for(int i=0; i<4; i++) {
        Virus next = new Virus(now.x + dir[i][0], now.y + dir[i][1]);
        if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= M || copyMap[next.x][next.y] != 0) continue;
        copyMap[next.x][next.y] = 2;
        q.offer(next);
      }
    }
    int sum = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(copyMap[i][j] == 0) sum++;
      }
    }
    return sum;
  }
  
  public static class Virus {
    int x;
    int y;
    Virus(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
