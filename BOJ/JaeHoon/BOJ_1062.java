package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {
  static boolean[] isStudy = new boolean[26];
  static String[] arr;
  static int K;
  static int N;
  static int max = 0;
  static int isUsedLength;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new String[N];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      arr[i] = s.substring(4, s.length()-4);
    }
    isStudy['a' - 'a'] = true;
    isStudy['n' - 'a'] = true;
    isStudy['t' - 'a'] = true;
    isStudy['i' - 'a'] = true;
    isStudy['c' - 'a'] = true;
    isUsedLength = 5;
    dfs(0, 0);
    System.out.println(max);
  }
  public static void dfs(int start,int sum) {
    if(sum == K-5) {
      int canReadLength = 0;
      for(int i=0; i<N; i++) {
        boolean read = true;
        for(int j=0; j<arr[i].length(); j++) {
          if(!isStudy[arr[i].charAt(j) - 'a']) {
            read = false;
            break;
          }
        }
        if(read) canReadLength++;
      }
      max = Math.max(max, canReadLength);
      return;
    }
    for(int i=start; i<26; i++) {
      if(!isStudy[i]) {
        isStudy[i] = true;
        dfs(i+1,sum+1);
        isStudy[i] = false;
      }
    }
  }
}
