package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2615 {
  static int[] dx = {1,-1,0,0,1,-1,1,-1};
  static int[] dy = {0,0,-1,1,1,-1,-1,-1};
  static int N;
  static int[][] map;
  static boolean[][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = 19;
    map = new int[N][N];
    isVisit = new boolean[N][N];

    ArrayList<int[]> whiteList = new ArrayList<>();
    ArrayList<int[]> blackList = new ArrayList<>();

    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 1) blackList.add(new int[]{i,j});
        else if(map[i][j] == 2) whiteList.add(new int[]{i,j});
      }
    }
    int answer = 0;
    int ax = 0;
    int ay = 0;
    for (int[] pos : blackList) {
      if(answer == 1) break;
      
      for(int i=0; i<8; i+=2) {
        int cnt = 1;
        int x = pos[0];
        int y = pos[1];
        int candiX = x;
        int candiY = y;
        while(cnt < 5) {
          x += dx[i];
          y += dy[i];
          if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 1) break;
          cnt++;
        }
        if(x < candiX) {
          candiX = x;
          candiY = y; 
        }
        int cnt2 = 0;
        while(cnt2 < 5) {
          x += dx[i+1];
          y += dy[i+1];
          if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 1) break;
          cnt2++;
        }
        if(x < candiX) {
          candiX = x;
          candiY = y; 
        }
        if(cnt + cnt2 == 5) {
          x += dx[i];
          y += dy[i];
          if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 1) {
            ax = candiX;
            ay = candiY;
            answer = 1;
            break;
          }
        }
      }
    }
    

    if(answer == 0) {
      for (int[] pos : whiteList) {
        if(answer == 2) break;
        
        for(int i=0; i<8; i+=2) {
          int cnt = 1;
          int x = pos[0];
          int y = pos[1];
          int candiX = x;
          int candiY = y;
          while(cnt < 5) {
            x += dx[i];
            y += dy[i];
            if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 2) break;
            cnt++;
          }
          if(x < candiX) {
            candiX = x;
            candiY = y; 
          }
          int cnt2 = 0;
          while(cnt2 < 5) {
            x += dx[i+1];
            y += dy[i+1];
            if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 2) break;
            cnt2++;
          }
          if(x < candiX) {
            candiX = x;
            candiY = y; 
          }
          if(cnt + cnt2 == 5) {
            x += dx[i];
            y += dy[i];
            if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 2) {
              ax = candiX;
              ay = candiY;
              answer = 1;
              break;
            }
          }
        }
      }
    }

    if(answer != 0) {
      System.out.println(answer);
      System.out.println((ax+1) + " " + (ay+1));
    }else {
      System.out.println(answer);
    }
  }
  // public static boolean dfs(int depth, int x, int y, int color) {
  //   if(depth == 5) return true;

  //   for(int i=0; i<8; i++) {
  //     int nextX = x + dx[i];
  //     int nextY = y + dy[i];
  //     if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || isVisit[nextX][nextY]) continue;
  //     if(map[nextX][nextY] == color) {
  //       isVisit[nextX][nextY] = true;
  //       if(dfs(depth+1, nextX, nextY, color)) return true;
  //       isVisit[nextX][nextY] = false;
  //     }
  //   }

  //   return false;
  // }
}
