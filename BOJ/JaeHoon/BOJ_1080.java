package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1080 {
  static int[][] map_one;
  static int[][] map_two; 
  static int N;
  static int M;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map_one = new int[N][M];
    map_two = new int[N][M];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map_one[i][j] = s.charAt(j) - '0';
      }
    }
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map_two[i][j] = s.charAt(j) - '0';
      }
    }


    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map_one[i][j] != map_two[i][j]) {
          changeMap(i,j);
        }
      }
    }

    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map_one[i][j] != map_two[i][j]) {
          changeMap(i,j);
        }
      }
    }
    System.out.println(check() ? answer : -1);
  }
  public static boolean check() {
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map_one[i][j] != map_two[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
  public static void changeMap(int row, int col) {
    if(row + 2 >= N || col + 2 >= M) return;
    for(int i=row; i<row+3; i++) {
      for(int j=col; j<col+3; j++) {
        if(map_one[i][j] == 0)
          map_one[i][j] = 1;
        else map_one[i][j] = 0;
      }
    }
    answer++;
    // for(int i=0; i<N; i++) {
    //   System.out.println(Arrays.toString(map_one[i]));
    // }
  }
}