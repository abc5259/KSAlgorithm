package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2234 {
  static int N, M;
  static int[][] map;
  static int[][] visit;
  static int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
  static Map<Integer,Integer> hMap = new HashMap<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[M][N];
    visit = new int[M][N];
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      } 
    }
    int num = 1;
    int second = 0;
    for(int i=0; i<M; i++) {
      for(int j=0; j<N; j++) {
        if(visit[i][j] == 0) {
          visit[i][j] = num;
          hMap.put(num, 1);
          dfs(num, i, j);
          second = Math.max(second, hMap.get(num));
          num++;
        }
      } 
    }

    int max = Integer.MIN_VALUE;
    for(int i=0; i<M; i++) {
      for(int j=0; j<N; j++) {
        for(int d=0; d<4; d++) {
          int nextX = i + dir[d][0];
          int nextY = j + dir[d][1];
          if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visit[i][j] == visit[nextX][nextY]) continue;
          max = Math.max(max, hMap.get(visit[i][j]) + hMap.get(visit[nextX][nextY]));
        }
      } 
    }

    System.out.println(hMap.size());
    System.out.println(second);
    System.out.println(max);
  }
  public static void dfs(int num, int row, int col) {
    int n = map[row][col];
    for(int i=0; i<4; i++) {
      if(((n >> i) & 1) == 1) continue;
      int nextR = row + dir[i][0];
      int nextC = col + dir[i][1];
      if(nextR < 0 || nextR >= M || nextC < 0 || nextC >= N || visit[nextR][nextC] != 0) continue;
      visit[nextR][nextC] = num;
      hMap.put(num, hMap.get(num)+1);
      dfs(num, nextR, nextC);
    }
  }
}
