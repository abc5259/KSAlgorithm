package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
  static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    int[][] map = new int[N][M];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      } 
    }

    st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    Dice dice = new Dice();
    for(int i=0; i<K; i++) {
      int num = Integer.parseInt(st.nextToken());
      int nextX = x + dir[num-1][0];
      int nextY = y + dir[num-1][1];

      if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

      x = nextX;
      y = nextY;

      switch(num) {
        case 1: 
          dice.goEast();
          break;
        case 2: 
          dice.goWest();
          break;
        case 3: 
          dice.goNorth();
          break;
        case 4: 
          dice.goSouth();
          break;
      }

      if(map[x][y] == 0) {
        map[x][y] = dice.getBottom();
      }else {
        dice.setBottom(map[x][y]);
        map[x][y] = 0;
      }
      sb.append(dice.getFront() + "\n");

    }

    System.out.println(sb);
  }
  static class Dice {
    int[][] nums = new int[4][3];
    public void goNorth() {
      int[][] copyNum = nums.clone();
      for(int i=0; i<4; i++)
        copyNum[i] = nums[i].clone();
      for(int i=0; i<4; i++) {
        int idx = (i + 1) % 4;
        nums[idx][1] = copyNum[i][1];
      }
    }
    public void goSouth() {
      int[][] copyNum = nums.clone();
      for(int i=0; i<4; i++)
        copyNum[i] = nums[i].clone();
      for(int i=0; i<4; i++) {
        int idx = (i + 1) % 4;
        nums[i][1] = copyNum[idx][1];
      }
    }
    public void goWest() {
      int[][] copyNum = nums.clone();
      for(int i=0; i<4; i++)
        copyNum[i] = nums[i].clone();

      nums[1][2] = copyNum[3][1];
      nums[1][1] = copyNum[1][2];
      nums[1][0] = copyNum[1][1];
      nums[3][1] = copyNum[1][0];
    }
    public void goEast() {
      int[][] copyNum = nums.clone();
      for(int i=0; i<4; i++)
        copyNum[i] = nums[i].clone();
      
      nums[1][2] = copyNum[1][1];
      nums[1][1] = copyNum[1][0];
      nums[1][0] = copyNum[3][1];
      nums[3][1] = copyNum[1][2];
    }
    public int getFront() {
      return nums[1][1];
    }
    public int getBottom() {
      return nums[3][1];
    }
    public void setBottom(int num) {
      nums[3][1] = num;
    }
  }
}
