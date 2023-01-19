package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16719 {
  static boolean[] isUsed;
  static String str;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    str = br.readLine();
  
    isUsed = new boolean[str.length()];
    solve(0, str.length()-1);
    System.out.println(sb);
  }
  public static void solve(int start, int end) {
    if(start > end || end >= str.length()) return;
    int mini = Integer.MAX_VALUE; // 사전순으로 가장 작은 char 
    int idx = -1; // 사전순으로 가장 작은 char의 인덱스 
    for(int i=start; i<=end; i++) {
      // start부터 end까지 사용되지 않으면서 mini보다 사전순으로 앞에 위차한다면 
      if(!isUsed[i] && str.charAt(i) < mini) {
        mini = str.charAt(i); // mini 업데이트 
        idx = i; // 인덱스 또한 업데이트
      }
    }
    // 사전순으로 가장 작은 char을 못구했을 경우 리턴 
    if(mini == Integer.MAX_VALUE) return;
    // 구했을경우 해당 인덱스 사용했다고 해주기 
    isUsed[idx] = true;
    // 정답 추가 
    String s = "";
    for(int i=0; i<str.length(); i++) {
      if(isUsed[i]) s+= str.charAt(i);
    }
    sb.append(s+"\n");
    // 찾은 인덱스 + 1부터 끝까지 다시 찾기 
    solve(idx+1, end);
    // 시작 부터 찾은 인덱스 -1 까지 다시 찾기 
    solve(start, idx-1);
  }
}
