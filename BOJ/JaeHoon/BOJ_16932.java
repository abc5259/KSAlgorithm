package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16932 {
  static int[][] board;
  static int[][] group;
  static Map<Integer,Integer> map = new HashMap<>();
  static int N,M;
  static boolean[][] isVisit;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    group = new int[N][M];
    isVisit = new boolean[N][M];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int key = 1;
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(board[i][j] == 1 && !isVisit[i][j])  {
          int cnt = bfs(i, j, key);
          map.put(key,cnt);
          key++;
        }
      }
    }
    int answer = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(board[i][j] == 0)  {
          int result = 1;
          HashSet<Integer> set = new HashSet<>();
          for(int k=0; k<4; k++) {
            int nextX = i + dir[k][0];
            int nextY = j + dir[k][1];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            if(map.containsKey(group[nextX][nextY]) && !set.contains(group[nextX][nextY])) {
              result += map.get(group[nextX][nextY]);
              set.add(group[nextX][nextY]);
            }
          }
          answer = Math.max(answer, result);
        }
      }
    }
    System.out.println(answer);
  }
  static public int bfs(int row, int col, int key) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{row,col});
    isVisit[row][col] = true;
    group[row][col] = key;
    int total = 1;
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      for(int i=0; i<4; i++) {
        int nextX = curr[0] + dir[i][0];
        int nextY = curr[1] + dir[i][1];
        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisit[nextX][nextY]) continue;
        if(board[nextX][nextY] == 0) continue;
        total++;
        group[nextX][nextY] = key;
        isVisit[nextX][nextY] = true;
        q.offer(new int[]{nextX,nextY});
      }
    }
    return total;
  }
}
