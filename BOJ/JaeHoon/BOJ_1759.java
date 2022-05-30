package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
  public static int L;
  public static int C;
  public static char[] arr;
  public static char[] items;
  public static boolean[] isUsed;
  public static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    arr = new char[L];
    items = new char[C];
    isUsed = new boolean[C];
    for(int i=0; i<C; i++) {
      items[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(items);
    func(0, 0,0,-1);
    System.out.println(sb);
  }
  public static void func(int depth,int vowelCnt,int cnt,int start) {
    if(depth == L) {
      if(vowelCnt < 1 || cnt <2) return;
      for(int i=0; i<L; i++) {
        sb.append(arr[i]);
      }
      sb.append('\n');
      return;
    }
    for(int i=0; i<C; i++) {
      if(!isUsed[i] && start < i) {
        arr[depth] = items[i];
        isUsed[i] = true;
        if(isVowel(items[i])) vowelCnt++;
        else cnt++;

        func(depth+1, vowelCnt,cnt,i);

        if(isVowel(items[i])) vowelCnt--;
        else cnt--;
        isUsed[i] = false;
      }
    }
  }
  public static boolean isVowel(char c) {
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
      return true;
    }
    return false;
  }
}
