package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
  static int[] home_x;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    home_x = new int[N];
    for(int i=0; i<N; i++) {
      home_x[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(home_x);
    int low = 1;
    int high = home_x[N-1] - home_x[0] + 1;
    int middle = 0;
    
    while(low < high) {
      middle = (low + high) / 2;
      if(getLength(middle) < C) {
        high = middle;
      } else {
        low = middle + 1;
      }
    }
    System.out.println(low-1);
  }
  public static int getLength(int dist) {
    int length = 1;
    int curr = home_x[0];
    for(int i=1; i<home_x.length; i++) {
      if(home_x[i] - curr >= dist) {
        length++;
        curr = home_x[i];
      }
    }
    return length;
  }
}
