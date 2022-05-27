package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10972 { 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    int N = sc.nextInt();
    int[] arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = sc.nextInt();
    }
    int index = -1;
    for(int i=N-1; i>=1; i--) {
      if(arr[i] > arr[i-1]) {
        int changeIndex = i;
        for(int j=i; j<N-1; j++) {
          if(arr[j] > arr[j+1] && arr[j+1] > arr[i-1]) changeIndex = j+1;
        }
        index = changeIndex;
        int temp = arr[changeIndex];
        arr[changeIndex] = arr[i-1];
        arr[i-1] = temp;
        index = i-1;
        break;
      }
    }
    if(index != -1) {
      Arrays.sort(arr, index+1, N);
    }
    for(int i=0; i<N; i++) {
      sb.append(arr[i] + " ");
    }
    if(index != -1) {
      System.out.println(sb);
    }else {
      System.out.println(-1);
    }
  }
}