package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10775 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int G = Integer.parseInt(br.readLine());
    int P = Integer.parseInt(br.readLine());

    int[] arr = new int[G+1];
    for(int i=1; i<=G; i++) arr[i] = i;

    int cnt = 0;
    boolean isOk = true;
    for(int i=1; i<=P; i++) {
      int g = Integer.parseInt(br.readLine());
      int gate = find(g, arr);
      if(gate == 0) isOk = false;
      if(isOk) {
        union(gate, gate-1, arr);
        cnt++;
      }

    }
    System.out.println(cnt);
  }
  public static int find(int x, int[] arr) {
    if(x == arr[x]) return x;
    return arr[x] = find(arr[x], arr);
  }
  public static void union(int x, int y, int[] arr) {
    x = find(x, arr);
    y = find(y, arr);

    if(x!=y) {
      arr[x] = y;
    }
  }
}
