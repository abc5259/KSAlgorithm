package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2529 {
  static int K;
  static String[] arr;
  static char[] nums;
  static boolean[] isUsed;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  static String maxStr = "";
  static String minStr = "";
  static boolean isFindMin = false;
  static boolean isFindMax = false;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine());
    arr = new String[K];
    nums = new char[K+1];
    isUsed = new boolean[10];
    arr = br.readLine().split(" ");
    minFunc(0);
    nums = new char[K+1];
    isUsed = new boolean[10];
    maxFunc(0);
    System.out.println(maxStr);
    System.out.println(minStr);
  }
  public static void minFunc(int depth) {
    if(isFindMin) return;
    if(depth == K+1) {
      boolean check = true;
      for(int i=0; i<K; i++) {
        if(arr[i].equals("<")) {
          if(nums[i] >nums[i+1]) check=false;
        } else {
          if(nums[i] < nums[i+1]) check=false;
        }
      }
      String num = new String(nums);
      if(check) {
        minStr = num;
        isFindMin = true;
      }
      return;
    }
    for(int i=0; i<10; i++) {
      if(!isUsed[i] && !isFindMin) {
        nums[depth] = (char)(i + '0');
        isUsed[i] = true;
        minFunc(depth+1);
        isUsed[i] = false;
      }
    }
  }

  public static void maxFunc(int depth) {
    if(isFindMax) return;
    if(depth == K+1) {
      boolean check = true;
      for(int i=0; i<K; i++) {
        if(arr[i].equals("<")) {
          if(nums[i] >nums[i+1]) check=false;
        } else {
          if(nums[i] < nums[i+1]) check=false;
        }
      }
      String num = new String(nums);
      if(check) {
        maxStr = num;
        isFindMax = true;
      }
      return;
    }
    for(int i=9; i>=0; i--) {
      if(!isUsed[i] && !isFindMax) {
        nums[depth] = (char)(i + '0');
        isUsed[i] = true;
        maxFunc(depth+1);
        isUsed[i] = false;
      }
    }
  }
}
