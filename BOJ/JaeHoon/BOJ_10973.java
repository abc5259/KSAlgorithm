package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10973 {
  public static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Integer[] arr = new Integer[N];
    for(int i=0; i<N; i++) {
      arr[i] = sc.nextInt();
    }
    if(result(arr)) {
      System.out.println(sb);
    }else {
      System.out.println(-1);
    }
  }
  public static boolean result(Integer[] arr) {
    int i = arr.length - 1;
    int j = arr.length - 1;
    while(i >= 1 && arr[i] >= arr[i-1]) {
      i--;
    }
    if(i == 0) {
      return false;
    }
    while(j > i && !(arr[j] < arr[i-1] && arr[j] > arr[i])) {
      j--;
    }
    swap(arr, i-1, j);
    Arrays.sort(arr, i, arr.length, (x,y)->y-x);
    for(int k=0; k<arr.length; k++) {
      sb.append(arr[k] + " ");
    }
    return true;
  }
  public static void swap(Integer[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}