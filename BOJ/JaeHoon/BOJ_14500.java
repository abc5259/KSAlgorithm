package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_14500 {
  static int N;
  static int M;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    int[][] arr = new int[N][M];
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    int max = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(indexExists(i+3,j)) {
          max = Math.max(max, arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j]);
        }
        if(indexExists(i,j+3)) {
          max = Math.max(max, arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3]);
        }
        if(indexExists(i+1,j+1)) {
          max = Math.max(max, arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1]);
        }
        if(indexExists(i+2,j+1)) {
          int sum1 =  arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
          int sum2 =  arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
          int sum3 =  arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
          int sum4 =  arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1];
          int sum5 =  arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i][j+1];
          max = Math.max(max, Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4))));
          max = Math.max(max, sum5);
        }
        if(indexExists(i+2,j-1)) {
          int sum1 =  arr[i][j] + arr[i+1][j] + arr[i+1][j-1] + arr[i+2][j-1];
          int sum2 =  arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j-1];
          max = Math.max(max, Math.max(sum1, sum2));
        }
        if(indexExists(i+1,j+2)) {
          int sum1 =  arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
          int sum2 =  arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
          int sum3 =  arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
          int sum4 =  arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
          int sum5 =  arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j];
          max = Math.max(max, Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4))));
          max = Math.max(max, sum5);
        }
        if(indexExists(i-1,j+2)) {
          int sum1 =  arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
          int sum2 =  arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];
          int sum3 =  arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+1];
          max = Math.max(max, Math.max(sum1, Math.max(sum2, sum3)));
        }
        if(indexExists(i-2,j+1)) {
          int sum =  arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-2][j+1];
          max = Math.max(max, sum);
        }
      }
    }
    System.out.println(max);
  }
  public static boolean indexExists(int i, int j) {
    if((i < 0  || N <= i) || (j < 0  || M <= j)) {
      return false;
    }
    return true;
  }
}
