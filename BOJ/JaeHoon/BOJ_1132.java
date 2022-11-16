package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1132 {
  static class AlphabetInfo implements Comparable<AlphabetInfo>{
    long score;
    boolean first = false;
    @Override
    public int compareTo(AlphabetInfo o) {
      return Long.compare(score, o.score);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    AlphabetInfo[] alphabetInfos = new AlphabetInfo[10];
    for(int i=0; i<10; i++)
      alphabetInfos[i] = new AlphabetInfo();
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      alphabetInfos[(int)(s.charAt(0) - 'A')].first = true;
      for(int j=0; j<s.length(); j++) {
        alphabetInfos[(int)(s.charAt(j) - 'A')].score += (long)Math.pow(10, s.length() -j - 1);
      }
    }
    long total = 0;
    Arrays.sort(alphabetInfos);
    boolean[] isUsed = new boolean[10];
    for(int i=0; i<10; i++) {
      if(alphabetInfos[i].first) {
        for(int j=1; j<10; j++) {
          if(!isUsed[j]) {
            total += alphabetInfos[i].score * j;
            isUsed[j] = true;
            break;
          }
        }
      }else {
        for(int j=0; j<10; j++) {
          if(!isUsed[j]) {
            total += alphabetInfos[i].score * j;
            isUsed[j] = true;
            break;
          }
        }
      }
    }
    System.out.println(total);
  }
}
