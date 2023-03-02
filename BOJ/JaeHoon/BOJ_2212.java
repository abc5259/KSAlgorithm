package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2212 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if(N <= K) {
      System.out.println(0);
      return;
    }

    Arrays.sort(arr);

    int answer = 0;

    Integer[] difArr = new Integer[N-1];
    for(int i=0; i<N-1; i++) {
      difArr[i] = arr[i+1] - arr[i];
    }
    Arrays.sort(difArr,(a,b)-> b-a);
    // 총 K개의 그룹이니깐 K-1개를 빼야함 
    
    for(int i = K-1; i < N-1; i++) {
			answer += difArr[i];
		}
    System.out.println(answer);
  }
}
