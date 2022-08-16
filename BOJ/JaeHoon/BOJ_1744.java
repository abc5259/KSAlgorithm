package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1744 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N =Integer.parseInt(br.readLine());
    ArrayList<Integer> minusNum = new ArrayList<>();
    ArrayList<Integer> plusNum = new ArrayList<>();
    for(int i=0; i<N; i++) {
      int num = Integer.parseInt(br.readLine());
      if(num < 0 || num == 0) {
        minusNum.add(num);
      }else {
        plusNum.add(num);
      }
    }
    Collections.sort(minusNum);
    Collections.sort(plusNum);
    int answer = 0;
    for(int i=plusNum.size()-1; i>=0; i-=2) {

      if(i-1 < 0 ) {
        answer += plusNum.get(i);
        continue;
      }

      if(plusNum.get(i) == 1 || plusNum.get(i-1) == 1) {
        answer += plusNum.get(i) + plusNum.get(i-1);
      }else {
        answer += plusNum.get(i) * plusNum.get(i-1);
      }

    }

    for(int i=0; i<minusNum.size(); i+=2) {
      if(i+1 >= minusNum.size()) {
        answer += minusNum.get(i);
        continue;
      }

      answer += minusNum.get(i) * minusNum.get(i+1);
    }
    System.out.println(answer);
  }

  public static boolean isMinus(int num) {
    return num > 0 ? false : true;
  }
}
// 음수는 음수*음수를 하던가 음수*0을하는게 최선임 -> 음수*얌수를 하면 안됨 
// 0은 음수랑 묶이지 않는다면 무조건 묶지않게 해야함
// 양수는 무조건 큰거*다음큰거를 해야 최선임
// 음수 음수
// 음수 0
// 음수 양수
// 양수 양수

// 6 5 4 3 2 1