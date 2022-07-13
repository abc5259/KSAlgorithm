package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1339 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    String[] arr = new String[N];
    int[] num = new int[26];
    for(int i=0; i<N; i++) {
      arr[i] = br.readLine();
    }
    for(int i=0; i<N; i++) {
      int temp = (int)Math.pow(10, arr[i].length() - 1);
      for(int j=0; j<arr[i].length(); j++) {
        num[(int)(arr[i].charAt(j) - 'A')] += temp;
        temp /= 10;
      }
    }
    Arrays.sort(num);
    int index = 9;
    int result = 0;
    for(int i=num.length-1; i>=0; i--) {
      if(num[i] == 0) break;
      result += num[i] * index;
      index--;
    }
    System.out.println(result);
  }
}