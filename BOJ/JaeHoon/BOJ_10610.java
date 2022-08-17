package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_10610 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split("");
    int sum = 0;
    boolean isZero = false;
    int result = -1;
    for(int i=0; i<arr.length; i++) {
      int curr = Integer.parseInt(arr[i]);
      sum += curr;
      if(curr == 0) isZero = true;
    }
    if(isZero && sum % 3 == 0) {
      Arrays.sort(arr,Collections.reverseOrder());
      System.out.println(String.join("",arr));
    }else {
      System.out.println(result);
    }
  }
}

// 길거리에서 양수 N 봄 -> N은 최대 10^5개의 숫자로 구성 0으로 시작 x
// 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수 만들기
// 3으로 나누어 떨어지는 수 -> 모든 자릿수를 더한게 3으로 나누어떨어져야함
// 10으로 나누어 떨어지는 수 -> 일의자리가 0이어야함
// 30으로 나누어 떨어지는 수 -> 3 && 10