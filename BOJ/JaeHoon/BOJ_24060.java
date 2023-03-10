package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060 {
  public static int[] tmp;
  static int K;
  static int answer = -1;
  static int cnt;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[] A = new int[N];
    tmp = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    merge_sort(A,0,N-1);
    System.out.println(answer);
  }
  public static void merge_sort(int[] A, int left, int right) {
    if(left == right) return;
    int mid = (left + right) / 2;
    merge_sort(A, left, mid);
    merge_sort(A, mid+1, right);

    merge(A, left, mid, right);
  }
  public static void merge(int[] A, int left, int mid, int right) {
      int l = left;
      int r = mid + 1;
      int idx = left;
      while(l <= mid && r <= right) {
        if(A[l] <= A[r]) {
          cnt++;
          tmp[idx] = A[l];
          idx++;
          l++;
        }
        else {
          cnt++;
          tmp[idx] = A[r];
          idx++;
          r++;
        }
        if(cnt == K) answer = tmp[idx-1];
      }

      if(l > mid) {
        while(r <= right) {
          cnt++;
          if(cnt == K) answer = A[r];
          tmp[idx] = A[r];
          idx++;
          r++;
        }
      }
      else {
        while(l <= mid) {
          cnt++;
          if(cnt == K) answer = A[l];
          tmp[idx] = A[l];
          idx++;
          l++;
        }
      }

      for(int i=left; i<=right; i++) {
        A[i] = tmp[i];
      }
  }
}
