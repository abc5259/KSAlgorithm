package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_17404 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] redDP = new int[N+1][3];
    int[][] greenDP = new int[N+1][3];
    int[][] bluedDP = new int[N+1][3];
    int[][] arr = new int[N+1][3];
    int[] paint = new int[3];
    for(int i=1; i<N+1; i++) {
      for(int j=0; j<3; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    redDP[1][0] = arr[1][0];
    redDP[1][1] = redDP[1][2] = 1001;

    greenDP[1][1] = arr[1][1];
    greenDP[1][0] = greenDP[1][2] = 1001;

    bluedDP[1][2] = arr[1][2];
    bluedDP[1][0] = bluedDP[1][1] = 1001;
    for(int i=2; i<N+1; i++) {
      redDP[i][0] = Math.min(redDP[i-1][1], redDP[i-1][2]) + arr[i][0];
      redDP[i][1] = Math.min(redDP[i-1][0], redDP[i-1][2]) + arr[i][1];
      redDP[i][2] = Math.min(redDP[i-1][0], redDP[i-1][1]) + arr[i][2];

      greenDP[i][0] = Math.min(greenDP[i-1][1], greenDP[i-1][2]) + arr[i][0];
      greenDP[i][1] = Math.min(greenDP[i-1][0], greenDP[i-1][2]) + arr[i][1];
      greenDP[i][2] = Math.min(greenDP[i-1][0], greenDP[i-1][1]) + arr[i][2];

      bluedDP[i][0] = Math.min(bluedDP[i-1][1], bluedDP[i-1][2]) + arr[i][0];
      bluedDP[i][1] = Math.min(bluedDP[i-1][0], bluedDP[i-1][2]) + arr[i][1];
      bluedDP[i][2] = Math.min(bluedDP[i-1][0], bluedDP[i-1][1]) + arr[i][2];

      if(i == N) {
        paint[0] = Math.min(redDP[N][1], redDP[N][2]);
        paint[1] = Math.min(greenDP[N][0], greenDP[N][2]);
        paint[2] = Math.min(bluedDP[N][0], bluedDP[N][1]);
      }
    }
    int result =  Math.min(paint[0], Math.min(paint[1], paint[2]));
    System.out.println(result);
  }
}
