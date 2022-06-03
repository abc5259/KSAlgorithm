package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1248 {
  static int N;
  static int[] nums;
  static boolean isFind;
  static char[][] arr;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    String str = br.readLine();
    arr = new char[N][N];
    nums = new int[N];
    int k = 0;
    for(int i=0; i<N; i++) {
      for(int j=i; j<N; j++) {
        arr[i][j] = str.charAt(k++);
      }
    }
    backTracking(0);
    System.out.println(sb);
  }
  public static void backTracking(int depth) {
    if(isFind) return;
    if(depth == N) {
      for(int i=0; i<N; i++) {
        sb.append(nums[i] + " ");
      }
      isFind = true;
      return;
    }
    for(int i=-10; i<=10; i++) {
      if(!isFind) {
        nums[depth] = i;
        if(check(depth)) {
          backTracking(depth+1);
        }
      }
    }
  }
  public static boolean check(int depth) {
    boolean isTrue = true;
    for(int i=0; i<=depth; i++) {
      int num = 0;
      for(int j=i; j<=depth; j++) {
        num += nums[j];
        if(arr[i][j] == '-') {
          if(num >= 0) {
            isTrue = false;
            return isTrue;
          }
        }
        else if(arr[i][j] == '+') {
          if(num <= 0) {
            isTrue = false;
            return isTrue;
          }
        }
        else if(arr[i][j] == '0') {
          if(num != 0) {
            isTrue = false;
            return isTrue;
          }
        }
      }
    }
    return isTrue;
  }
}
