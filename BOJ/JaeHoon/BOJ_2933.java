package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2933 {
  static int R,C;
  static char[][] map;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,1,-1};
  static boolean[][] isVisit;
  static boolean isOneFloor;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    
    for(int i=0; i<R; i++) {
      String s = br.readLine();
      for(int j=0; j<C; j++) {
        map[i][j] = s.charAt(j);
      } 
    }
    
    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    boolean turn = false;
    for(int i=0; i<N; i++) {
      int h = Math.abs(Integer.parseInt(st.nextToken()) - R);
      if(turn) {  // 오른쪽 던지기 
        rightThrowSpear(h);
      }else { //왼쪽 던지기 
        leftThrowSpear(h);
      }
      for(int k=0; k<R; k++) {
        for(int l=0; l<C; l++) {
          if(map[k][l] != '.') {
            map[k][l] = 'x';
          }
        }
      }
      turn = !turn; //턴 바꾸기 
    }
    StringBuffer sb = new StringBuffer();
    for(int k=0; k<R; k++) {
      for(int j=0; j<C; j++) {
        if(map[k][j] == '.') {
          sb.append(".");
        }else {
          sb.append("x");
        }
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
  public static void leftThrowSpear(int h) {
    for(int i=0; i<C; i++) {
      if(map[h][i] != '.') {
        map[h][i] = '.';
        int num = 1;
        for(int j=0; j<4; j++) {
          int nextX = h + dx[j];
          int nextY = i + dy[j];

          if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
          if(map[nextX][nextY] != '.') {
            isVisit = new boolean[R][C];
            findCluster(nextX, nextY, num);
            if(!isOneFloor) { // 바닥에 닫지 않는 클러스터라면  
              downCluster(num); // 내리기 
              break;
            }
            
            num++;
            isOneFloor = false;
          }
        }
        return;
      }
    }
  }
  public static void rightThrowSpear(int h) {
    for(int i=C-1; i>=0; i--) {
      if(map[h][i] != '.') {
        map[h][i] = '.';
        int num = 1;
        for(int j=0; j<4; j++) {
          int nextX = h + dx[j];
          int nextY = i + dy[j];

          if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
          if(map[nextX][nextY] != '.') {
            isVisit = new boolean[R][C];
            findCluster(nextX, nextY, num);
            if(!isOneFloor) { // 바닥에 닫지 않는 클러스터라면  
              downCluster(num); // 내리기 
              break;
            }
            
            num++;
            isOneFloor = false;
          }
        }
        return;
      }
    }
  }
  public static void findCluster(int x, int y, int num) {
    isVisit[x][y] = true;
    map[x][y] = (char) (num + '0');
    if(x == R-1) isOneFloor = true;

    for(int i=0; i<4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      
      if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || isVisit[nextX][nextY]) continue;
      if(map[nextX][nextY] != '.') {
        findCluster(nextX,nextY,num);
      }
    }
  }
  public static void downCluster(int num) {
    Queue<int[]> q = new LinkedList<>();

    for(int col=0; col<C; col++) {
      for(int row=R-1; row>=0; row--) {
        if(map[row][col] == num + '0') {
          q.offer(new int[]{row,col});
          break;
        }
      } 
    }

    int size = q.size();
    int minDownCnt = Integer.MAX_VALUE;
    while(size > 0) {
      int[] mineral = q.poll();
      int downCnt = 0;
      for(int i=mineral[0]+1; i<R; i++) {
        if(map[i][mineral[1]] == '.') {
          downCnt++;
        }
        else break;
      }
      minDownCnt = Math.min(minDownCnt, downCnt);
      size--;
    }

    for(int i=R-1; i>=0; i--) {
      for(int j=0; j<C; j++) {
        if(map[i][j] == num + '0') {
          map[i + minDownCnt][j] = 'x';
          map[i][j] = '.';
        }
      } 
    }

  }
}
