package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2513 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    List<Apart> left = new ArrayList<>();
    List<Apart> right = new ArrayList<>();
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int pos = Integer.parseInt(st.nextToken());
      int cnt = Integer.parseInt(st.nextToken());
      if(pos < S) 
        left.add(new Apart(pos, cnt));
      else 
        right.add(new Apart(pos, cnt));
    }
    
    int answer = 0;
    if(left.size() > 0) {
      Collections.sort(left, (Apart o1, Apart o2) -> o1.pos - o2.pos);
      int idx = 0;
      int pickCnt = K;
      boolean isBack = false;
      while(idx < left.size()) {  
        if(!isBack) {
          answer += S - left.get(idx).pos;
        }
        if(left.get(idx).cnt < pickCnt) {
          pickCnt -= left.get(idx).cnt;
          idx++;
          if(idx == left.size()) {
            answer += S - left.get(idx-1).pos;
            isBack = false;
          }else {
            answer += left.get(idx).pos - left.get(idx-1).pos;
            isBack = true;
          }
        }
        else  if(left.get(idx).cnt == pickCnt) {
          pickCnt = K;
          answer += S - left.get(idx).pos;
          idx++;
          isBack = false;
        }
        else  if(left.get(idx).cnt > pickCnt) {
          left.get(idx).cnt -= pickCnt;
          answer += S - left.get(idx).pos;
          isBack = false;
          pickCnt = K;
        }
      }
    }
    if(right.size() > 0) {
      Collections.sort(right, (Apart o1, Apart o2) -> o2.pos - o1.pos);
      int idx = 0;
      int pickCnt = K;
      boolean isBack = false;
      while(idx < right.size()) {  
        if(!isBack) {
          answer += right.get(idx).pos - S;
        }
        if(right.get(idx).cnt < pickCnt) {
          pickCnt -= right.get(idx).cnt;
          idx++;
          if(idx == right.size()) {
            answer += right.get(idx-1).pos - S;
            isBack = false;
          }else {
            answer += right.get(idx - 1).pos - right.get(idx).pos;
            isBack = true;
          }
        }
        else  if(right.get(idx).cnt == pickCnt) {
          pickCnt = K;
          answer += right.get(idx).pos - S;
          idx++;
          isBack = false;
        }
        else  if(right.get(idx).cnt > pickCnt) {
          right.get(idx).cnt -= pickCnt;
          answer += right.get(idx).pos - S;
          isBack = false;
          pickCnt = K;
        }
      }
    }
    System.out.println(answer);
  }
  static class Apart {
    int pos,cnt;
    Apart(int pos, int cnt) {
      this.pos = pos;
      this.cnt = cnt;
    }
  }
}
