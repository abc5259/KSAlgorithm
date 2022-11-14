package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_5545 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int C = Integer.parseInt(st.nextToken());
    Integer[] arr = new Integer[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr,Collections.reverseOrder());

    int total = C;
    int cost = A;
    for(int i=0; i<N; i++) {
      if(total / cost <= (total + arr[i]) / (cost + B)) {
        total += arr[i];
        cost += B;
      }else {
        break;
      }
    }
    System.out.println(total / cost);
  }
}
