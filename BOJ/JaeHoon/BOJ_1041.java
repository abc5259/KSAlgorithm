package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1041 {
  static List<char[]> threeList = new ArrayList<>();
  static List<char[]> twoList = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    threeList.add(new char[]{'A','C','E'});
    threeList.add(new char[]{'A','C','B'});
    threeList.add(new char[]{'A','D','B'});
    threeList.add(new char[]{'A','D','E'});
    threeList.add(new char[]{'F','C','E'});
    threeList.add(new char[]{'F','C','B'});
    threeList.add(new char[]{'F','D','B'});
    threeList.add(new char[]{'F','D','E'});

    twoList.add(new char[]{'A', 'B'});
    twoList.add(new char[]{'A', 'C'});
    twoList.add(new char[]{'A', 'D'});
    twoList.add(new char[]{'A', 'E'});
    twoList.add(new char[]{'B', 'C'});
    twoList.add(new char[]{'B', 'D'});
    twoList.add(new char[]{'B', 'F'});
    twoList.add(new char[]{'C', 'E'});
    twoList.add(new char[]{'C', 'F'});
    twoList.add(new char[]{'D', 'E'});
    twoList.add(new char[]{'D', 'F'});
    twoList.add(new char[]{'E', 'F'});

    long N = Integer.parseInt(st.nextToken());
    long[] arr = new long[6];
    st = new StringTokenizer(br.readLine());
    long min = Integer.MAX_VALUE;
    long max = 0;
    for(int i=0; i<6; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }
    if(N == 1) {
      int sum = 0;
      for(int i=0; i<6; i++) sum += arr[i];
      System.out.println(sum - max);
      return;
    }

    long threeMin = threeList.stream().mapToLong((ar) -> arr[ar[0] - 'A'] + arr[ar[1] - 'A'] + arr[ar[2] - 'A']).min().getAsLong();
    long twoMin = twoList.stream().mapToLong((ar) -> arr[ar[0] - 'A'] + arr[ar[1] - 'A']).min().getAsLong();

    long result = 4 * (threeMin) + 4*(N-2) * twoMin + (N-2) * (N-2) * min; 
    result += (N-1) * (4 * twoMin + 4*(N-2) * min);
    System.out.println(result);
  }
}
