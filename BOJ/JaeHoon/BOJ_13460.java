package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
  static char[][] board;
  static Queue<Point> q = new LinkedList<>();
  static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
  static int N;
  static int M;
  static Point red;
  static Point blue;
  static boolean[][][][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    isVisit = new boolean[N][M][N][M];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        char c = s.charAt(j);
        board[i][j] = c;
        if(c == 'R')  
          red = new Point(i, j, 0);
        if(c == 'B')
          blue = new Point(i, j, 0);
      }  
    }
    System.out.println(bfs());
  }
  static int bfs() {
    q.offer(red);
    q.offer(blue);
    isVisit[red.x][red.y][blue.x][blue.y] = true;
    while(!q.isEmpty()) {
      Point nowRed = q.poll();
      Point nowBlue = q.poll();
      if(nowRed.cnt > 10) return -1;
      for(int i=0; i<4; i++) {
        int prevRedX = nowRed.x;
        int prevRedY = nowRed.y;
        int nextRedX = nowRed.x;
        int nextRedY = nowRed.y;
        int redMove = 0;
        while(board[nextRedX][nextRedY] != 'O' && board[nextRedX][nextRedY] != '#') {
          prevRedX = nextRedX;
          prevRedY = nextRedY;
          nextRedX += dir[i][0];
          nextRedY += dir[i][1];
          redMove++;
        }
    
        int prevBlueX = nowBlue.x;
        int prevBlueY = nowBlue.y;
        int nextBlueX = nowBlue.x;
        int nextBlueY = nowBlue.y;
        int blueMove = 0;
        while(board[nextBlueX][nextBlueY] != 'O' && board[nextBlueX][nextBlueY] != '#') {
          prevBlueX = nextBlueX;
          prevBlueY = nextBlueY;
          nextBlueX += dir[i][0];
          nextBlueY += dir[i][1];
          blueMove++;
        }
        if(board[nextRedX][nextRedY] == 'O' && board[nextBlueX][nextBlueY] == 'O')
          continue;
        if(board[nextBlueX][nextBlueY] == 'O' && board[nextRedX][nextRedY] != 'O')
          continue;
        if(board[nextRedX][nextRedY] == 'O' && board[nextBlueX][nextBlueY] != 'O') 
          return nowRed.cnt + 1;
        if(prevRedX == prevBlueX && prevRedY == prevBlueY) {
          if(redMove < blueMove) {
            prevBlueX -= dir[i][0];
            prevBlueY -= dir[i][1];
          }
          else if(redMove > blueMove) {
            prevRedX -= dir[i][0];
            prevRedY -= dir[i][1];
          }
        }
        if(nowRed.cnt + 1 > 10) return -1;
        if(!isVisit[prevRedX][prevRedY][prevBlueX][prevBlueY]) {
          isVisit[prevRedX][prevRedY][prevBlueX][prevBlueY] = true;
          q.offer(new Point(prevRedX, prevRedY, nowRed.cnt+1));
          q.offer(new Point(prevBlueX, prevBlueY, nowBlue.cnt+1));
        }
      }
    }
    return -1;
  }
  static class Point  {
    int x;
    int y;
    int cnt;
    Point(int x, int y,int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
  }
}
