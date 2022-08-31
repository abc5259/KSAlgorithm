package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketPermission;
import java.util.StringTokenizer;

public class BOJ_1654 {
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    arr = new int[K];
    Long low = 0L;
    Long high = 0L;
    for(int i=0; i<K; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      high = Math.max(arr[i], high);
    }
    high++;
    while(low < high) {
      Long middle = (low + high) / 2;
      Long length = getLength(middle);
      if(length < N) {
        high = middle;
      } else {
        low = middle + 1;
      }
    }
    System.out.println(low-1);
  }
  public static Long getLength(Long num) {
    Long sum = 0L;
    for(int i=0; i<arr.length; i++)
      sum += arr[i] / num;
    return sum;
  }
}

// 802 743 447 539 -> 11개의 랜선으로 
//  4   3   2   2 