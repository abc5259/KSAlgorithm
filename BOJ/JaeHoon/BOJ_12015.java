package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12015 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] A = new int[N];
    ArrayList<Integer> LIS = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    LIS.add(A[0]);
    for(int i=1; i<N; i++) {
      int key = A[i];
      // LIS의 젤 마지막 원소 값보다 크다면 LIS에 넣어주기
      if(LIS.get(LIS.size() - 1) < A[i]) {
        LIS.add(key);
      }else {
        int low = 0;
        int high = LIS.size();
        while(low < high) {
          int middle = (low+high)/2;
          if(LIS.get(middle) < key) {
            low = middle+1;
          }else {
            high = middle;
          }
        }
        LIS.set(low, key);
      }
    }
    System.out.println(LIS.size());
  }
}
// 10 20 10 30 20 30 50
//             3   2 1
// 10 -> 20 -> 30 -> 50
// 20 -> 30 -> 50
// 10 20 10 30 20 50
//        3  2    2  1 
