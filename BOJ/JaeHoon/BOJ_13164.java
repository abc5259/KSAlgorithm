package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] student = new int[N];
    for(int i=0; i<N; i++) {
      student[i] = Integer.parseInt(st.nextToken());
    }

    int[] gapArr = new int[N-1];
    for(int i=0; i<N-1; i++) {
      gapArr[i] = student[i+1] - student[i];
    }

    Arrays.sort(gapArr);

    int dif = student[N-1]  - student[0];

    int idx = N-2;
    for(int i=1; i<=K-1; i++) {
      dif -= gapArr[idx];
      idx--;
    }
    System.out.println(dif);
  }
}
