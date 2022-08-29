package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10825 {
  public static class Study {
    String name;
    int korean,english,math;
    Study(String name, int korean, int english, int math) {
      this.name = name;
      this.korean = korean;
      this.english = english;
      this.math = math;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    Study[] studies = new Study[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int korean = Integer.parseInt(st.nextToken());
      int english = Integer.parseInt(st.nextToken());
      int math = Integer.parseInt(st.nextToken());
      studies[i] = new Study(name, korean, english, math);
    }
    Arrays.sort(studies, (Study o1, Study o2) -> {
      if(o1.korean != o2.korean) return o2.korean - o1.korean;
      else if(o1.english != o2.english) return o1.english - o2.english;
      else if(o1.math != o2.math) return o2.math - o1.math;
      return o1.name.compareTo(o2.name);
    });
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<N; i++) {
      sb.append(studies[i].name).append('\n');
    }
    System.out.println(sb);
  }
}
// 국어 점수가 감소하는 순서로
// 국어 점수가 같으면 영어 점수가 증가하는 순서로
// 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
// 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
