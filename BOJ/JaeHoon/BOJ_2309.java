package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[9];
    int[] notAnser = new int[2];
    int sum = 0;
    for(int i=0; i<9; i++) {
      arr[i] = sc.nextInt();
      sum += arr[i];
    }
    int temp = sum;
    for(int i=0; i<8; i++) {
      for(int j=i+1; j<9; j++) {
        sum = temp - (arr[i] + arr[j]);
        if(sum == 100) {
          notAnser[0] = arr[i];
          notAnser[1] = arr[j];
          break;
        }
      }
    }
    Arrays.sort(arr);
    for(int i=0; i<9; i++) {
      if(arr[i] == notAnser[0] || arr[i] == notAnser[1]) continue;
      System.out.println(arr[i]);
    }
  }
}
