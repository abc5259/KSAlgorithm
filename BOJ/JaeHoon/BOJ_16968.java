package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16968 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int num_cnt = 0;
    int english_cnt = 0;
    int answer = 1;
    for(int i=0; i<s.length(); i++) {
      if(s.charAt(i) == 'c') {
        if(english_cnt == 1) {
          answer *= 25;
        }else {
          answer *= 26;
          english_cnt = 1;
        }
        num_cnt = 0;
      }else {
        if(num_cnt == 1) {
          answer *= 9;
        }else {
          answer *= 10;
          num_cnt = 1;
        }
        english_cnt = 0;
      }
    }
    System.out.println(answer);
  }
}
