package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16946 {
  static int N;
  static int M;
  static int[][] map;
  static int[][] dir = {{1,0},{-1,0},{0,1}, {0,-1}};
  static HashMap<Integer,Integer> hashMap = new HashMap<>();
  static int[][] groupMap;  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    groupMap = new int[N][M];
    int groupNum = 1;
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j) - '0';
      } 
    }
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map[i][j] == 0 && groupMap[i][j] == 0) {
          hashMap.put(groupNum,bfs(new Point(i, j), groupNum));
          groupNum++;
        }
      }
    }
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        sb.append(goLength(i, j));
      }
      sb.append('\n');
    }
    System.out.print(sb);
  }
  public static int goLength(int row, int col) {
    if(map[row][col] == 0) return 0;

    int result = 1;
    HashSet<Integer> hs = new HashSet<>();

    for(int i=0; i<4; i++) {
      int nextX = row + dir[i][0];
      int nextY = col + dir[i][1];
      if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
      if(groupMap[nextX][nextY] == 0) continue;
      if(map[nextX][nextY] == 0) {
        hs.add(groupMap[nextX][nextY]);
      }
    }
    for(int i:hs) {
      result += hashMap.get(i);
    }
    return result % 10;
  }
  public static int bfs(Point start,int groupNum) {
    int count = 1;
    Queue<Point> q = new LinkedList<>();
    q.offer(start);
    groupMap[start.x][start.y] = groupNum;

    while(!q.isEmpty()) {
      Point now = q.poll();

      for(int i=0; i<4; i++) {
        int nextX = now.x + dir[i][0];
        int nextY = now.y + dir[i][1];

        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

        if(map[nextX][nextY] == 0 && groupMap[nextX][nextY] == 0) {
          q.offer(new Point(nextX, nextY));
          groupMap[nextX][nextY] = groupNum;
          count++;
        } 
      }
    }
    return count;
  }
  public static class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}