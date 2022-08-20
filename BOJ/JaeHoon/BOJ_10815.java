package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int[] arr2 = new int[M];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++) {
      arr2[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    for(int i=0; i<M; i++) {
      int target = arr2[i];
      int low = 0;
      int high = N-1;
      int middle = (low + high) / 2;
      while(low < high) {
        middle = (low + high) / 2;
        if(arr[middle] < target)  {
          low = middle + 1;
        }
        else {
          high = middle;
        }
      }
      sb.append(target == arr[low] ? 1 : 0).append(" ");
    }
    System.out.println(sb);
  }
}
