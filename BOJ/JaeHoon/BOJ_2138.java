package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {
  static int[] bulb_one_A;
  static int[] bulb_one_B;
  static int[] bulb_two;
  static int N;
  static int answer = 0;
  static int answer2 = 0;
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    bulb_one_A = new int[N];
    bulb_one_B = new int[N];
    bulb_two = new int[N];
    String s1 = br.readLine();
    String s2 = br.readLine();
    for(int i = 0; i<N; i++) {
      bulb_one_A[i] = s1.charAt(i) - '0';
      bulb_one_B[i] = s1.charAt(i) - '0';
      bulb_two[i] = s2.charAt(i) - '0';
    }

    // 1번 전구는 건들지 말고 시작 bulb_one_A
    for(int i=1; i<N; i++) {
      if(bulb_one_A[i-1] != bulb_two[i-1]) {
        changeBlub(i,bulb_one_A);
        answer++;
      }
    }

    // 1번 전구를 키고 시작
    onOneBlub(bulb_one_B);
    answer2++;
    for(int i=1; i<N; i++) {
      if(bulb_one_B[i-1] != bulb_two[i-1]) {
        changeBlub(i,bulb_one_B);
        answer2++;
      }
    }
    if(check(bulb_one_A)) {
      result = answer;
    }
    if(check(bulb_one_B)) {
      result = Math.min(result, answer2);
    }
    if(result == Integer.MAX_VALUE) {
      result = -1;
    }
    System.out.println(result);
  }
  public static boolean check(int[] blub) {
    for(int i=0; i<N; i++) {
      if(blub[i] != bulb_two[i]) return false;
    }
    return true;
  }
  public static void onOneBlub(int[] blub) {
    for(int i=0; i<=1; i++) {
      if(blub[i] == 0)
        blub[i] = 1;
      else blub[i] = 0;
    }
  }
  public static void changeBlub(int row, int[] blub) {
    int start = row - 1;
    int end = row == N-1 ? row : row + 1;
    for(int i=start; i<=end; i++) {
      if(blub[i] == 0)
        blub[i] = 1;
      else blub[i] = 0;
    }
  }
}
