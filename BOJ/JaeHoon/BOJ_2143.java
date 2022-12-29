package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2143 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    
    int n = Integer.parseInt(br.readLine());
    int[] A = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++)
      A[i] = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());
    int[] B = new int[m];
    st = new StringTokenizer(br.readLine()); 
    for(int i=0; i<m; i++)
      B[i] = Integer.parseInt(st.nextToken());

    
    //A합 저장 배열
    ArrayList<Integer> A_sum = new ArrayList<>();
    ArrayList<Integer> B_sum = new ArrayList<>();

    for(int i=0; i<n; i++) {
      int sum = 0;
      for(int j=i; j<n; j++) {
        sum += A[j];
        A_sum.add(sum);
      }
    }
    for(int i=0; i<m; i++) {
      int sum = 0;
      for(int j=i; j<m; j++) {
        sum += B[j];
        B_sum.add(sum);
      }
    }
    
    Collections.sort(A_sum);
    Collections.sort(B_sum);

    long answer = 0;

    int left = 0;
    int right = B_sum.size() - 1;

    while(left < A_sum.size() && right > -1) {
      int l = A_sum.get(left);
      int r = B_sum.get(right);
      long sum = l + r;
      if(sum == T) {
        long ac=0,bc=0;
        while(left < A_sum.size() && A_sum.get(left) == l) {
          left++;
          ac++;
        }

        while(right > -1 && B_sum.get(right) == r) {
          right--;
          bc++;
        }
        answer += ac * bc;
      }
      else if (sum < T) {
        left++;
      }
      else {
        right--;
      }
    }


    System.out.println(answer);

    
   
  }

}
