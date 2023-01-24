package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058 {
  static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
  static int[][] board;
  static int N,Q;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
    Q = Integer.parseInt(st.nextToken());

    board = new int[N][N];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      } 
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<Q; i++) {
      int num = Integer.parseInt(st.nextToken());
      int L = (int)Math.pow(2, num);
      board = divide(L);
      board = melt();
    }
    System.out.println(sum());
    System.out.println(bigLump());
  }
  public static int sum() {
    int sum = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if(board[i][j] <= 0) continue;
        sum += board[i][j];
      }
    }
    return sum;
  }
  public static int bigLump() {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visit;
    int max = Integer.MIN_VALUE;
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if(board[i][j] <= 0) continue;
        visit = new boolean[N][N];
        q.offer(new int[]{i,j});
        visit[i][j] = true;
        int size = 1;
        while(!q.isEmpty()) {
          int[] curr = q.poll();
          for(int k=0; k<4; k++) {
            int x = curr[0] + dir[k][0];
            int y = curr[1] + dir[k][1];
            if(x < 0 || x >= N || y < 0 || y >= N || board[x][y] <= 0 || visit[x][y]) continue;
            visit[x][y] = true;
            size++;
            q.offer(new int[]{x,y});
          }
        }
        max = Math.max(max, size);
      } 
    }
    return max == Integer.MIN_VALUE ? 0 : max;
  }
  public static int[][] divide(int L) {
    int[][] temp = new int[N][N];
    for(int i=0; i<N; i+=L) {
      for(int j=0; j<N; j+=L) {
        spin(i, j, L, temp);
      } 
    }
    return temp;
  }
  public static void spin(int row, int col, int L, int[][] temp) {
    for(int i=0; i<L; i++) {
      for(int j=0; j<L; j++) {
        temp[row + j][col + i] = board[row + L - 1 - i][col + j];
      } 
    }
  }
  public static int[][] melt() {
    int[][] copyBoard = board.clone();
    for(int i=0; i<N; i++) 
      copyBoard[i] = board[i].clone();
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        // 얼음이 없는경우 넘기기 

        int cnt = 0;
        for(int d=0; d<4; d++) {
          int x = i + dir[d][0];
          int y = j + dir[d][1];
          if(x < 0 || x >= N || y < 0 || y >= N) continue;
          if(board[x][y] >= 1) cnt++;
        }
        // 인접한 얼음이 3개 미만이라면 얼음양 줄이기
        if(cnt < 3) {
          copyBoard[i][j] -= 1;
        }
      } 
    }

    return copyBoard;
  }
}
