package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135 {
  static int[][] board;
  static int N,M,D;
  static int[][] archerArr = new int[3][2];
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    board = new int[N+1][M]; //+1은 궁수가 있는 곳  
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    archerPos(0, 0);

    System.out.println(answer);
  }
  public static void archerPos(int depth, int start) {
    if(depth == 3) {
      answer = Math.max(answer, solve());
      return;
    }

    for(int i=start; i<M; i++) {
      archerArr[depth][0] = N;
      archerArr[depth][1] = i;
      archerPos(depth+1,i+1);
    }
  }
  public static int solve() {
    int[][] copyBoard = deepCopy();
    
    int turn = 0;
    int startLine = N-1;
    int deathCnt = 0;
    for(int i=startLine; i>=0; i--) {
      int[] aPos = getMinDist(i, 0, turn,copyBoard);
      int[] bPos = getMinDist(i, 1, turn,copyBoard);
      int[] cPos = getMinDist(i, 2, turn,copyBoard);

      if(aPos[0] != -1) { // 죽일 적이 있다면 
        copyBoard[aPos[0]][aPos[1]] = 0; // 적 죽임 
        deathCnt++; // 죽인 카운트 +1
      }

      if(bPos[0] != -1) { // 죽일 적이 있다면
        if(copyBoard[bPos[0]][bPos[1]] != 0) { // a가 죽이지 않았다면 
          copyBoard[bPos[0]][bPos[1]] = 0; // 적 죽임 
          deathCnt++; // 죽인 카운트 +1
        }
      }

      if(cPos[0] != -1) { // 죽일 적이 있다면
        if(copyBoard[cPos[0]][cPos[1]] != 0) { // a나 b가 죽이지 않았다면 
          copyBoard[cPos[0]][cPos[1]] = 0; // 적 죽임 
          deathCnt++; // 죽인 카운트 +1
        }
      }

      turn++; // 턴 +1;
    }
    return deathCnt;
  }
  public static int[] getMinDist(int startLine, int archerIdx, int turn, int[][] copyBoard) {
    int[] minPos = {-1,-1};
    int minDist = Integer.MAX_VALUE;
    for(int i=startLine; i>=0; i--) {
      for(int j=0; j<M; j++) {
        if(copyBoard[i][j] == 0) continue; // 적이 없다면 다음으로

        int dist = distance(archerArr[archerIdx][0] - turn, archerArr[archerIdx][1], i, j);
        if(dist > D) continue; // 사정거리안에 안들어 온다면 다음으로 
        
        if(dist < minDist) {
          minDist = dist;
          minPos[0] = i;
          minPos[1] = j;
        }
        else if(dist == minDist) {
          if(j < minPos[1]) { // 더 왼쪽에 위차하면 
            minDist = dist;
            minPos[0] = i;
            minPos[1] = j;
          }
        }
      }
    }
    return minPos;
  }
  public static int[][] deepCopy() {
    int[][] copyBoard = board.clone();
    for(int i=0; i<N; i++)
      copyBoard[i] = board[i].clone();
    return copyBoard;
  }
  public static int distance(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}
 