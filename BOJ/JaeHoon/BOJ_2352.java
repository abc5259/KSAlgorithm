package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2352 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] list = new int[N];
    list[0] = arr[0];
    int end = 0;
    for(int i=1; i<N; i++) {
      if(list[end] < arr[i]) {
        end += 1;
        list[end] = arr[i];
      }else {
        int idx = pos(end, list, arr[i]);
        list[idx] = arr[i];
      }
    }

    System.out.println(end + 1);
  }
  public static int pos(int end, int[] list, int target) {
    int low = 0;
    int high = end;
    while(low < high) {
      int mid = (low + high) / 2;

      if(target > list[mid]) {
        low = mid + 1;
      }else {
        high = mid;
      }
    }
    return high;
  }
}
