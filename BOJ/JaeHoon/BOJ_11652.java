package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11652 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Long[] arr = new Long[N];
    for(int i=0; i<N; i++) {
      Long num = Long.parseLong(br.readLine());
      arr[i] = num;
    }
    Arrays.sort(arr);
    Long answer = arr[0];
    int preLength = Integer.MIN_VALUE;
    int currLength = 1;
    Long curr = arr[0];
    for(int i=1; i<N; i++) {
      if(curr - arr[i] == 0) currLength++;
      else {
        if(preLength < currLength) {
          preLength = currLength;
          answer = curr;
        }
        curr = arr[i];
        currLength = 1;
      }
    }
    if(preLength < currLength) {
      preLength = currLength;
      answer = curr;
    }
    System.out.println(answer);
  }
}
