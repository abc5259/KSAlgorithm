package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int max = 0;
    int prevSum = 0;
    for(int i=0; i<X; i++) {
      max += arr[i];
      prevSum += arr[i];
    }
    int answer = 1;
    for(int i=1; i<N; i++) {
      if(i+X-1 >= N) break;
      int currSum = prevSum - arr[i-1] + arr[i+X-1];
      prevSum = currSum;
      if(max == currSum) answer++;
      else if(max < currSum) {
        max = currSum;
        answer = 1;
      }
    }
    if(max == 0) System.out.println("SAD");
    else {
      System.out.println(max);
      System.out.println(answer);
    }
  }
}
