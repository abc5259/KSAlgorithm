package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12970 {
  static int N;
  static int K;
  static int ALength = 0;
  static String s = "";
  static String[] result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    ALength = checkALength();
    int BLength = N - ALength;
    result = new String[N];
    if(ALength != -1 && K != 0) {
      for(int i=0; i<N; i++) {
        result[i] = "B";
      }
      for(int i=0; i<ALength-1; i++) {
        result[i] = "A";
      }
      int c = (ALength - 1) * BLength;
      int r = K - c;
      result[(N-1)-r] = "A";
    }
    else if (K == 0) {
      for(int i=0; i<N; i++) {
        result[i] = "B";
      }
    }
    System.out.println(ALength == -1 ? -1 : String.join("", result));
  }
  public static int checkALength() {
    int ALength = 1;
    int BLength = N - 1;
    while(ALength*BLength < K) {
      if(BLength < 0) return -1;
      ALength++;
      BLength--;
    }
    return ALength;
  }
}

// 정수 N과 K가 주어졌을 때 문자열 S를 찾는 프로그램
// S 길이 N |  A,B로만 이루어져있음
// 0 ≤ i < j < N, s[i] == 'A' && s[j] == 'B'를 만족하는 (i, j) 쌍이 K개
// -> K가 0 이라면 A는 B왼쪽에 올 수 없음 무조건 오른쪽에 위치
// -> K기 1 이라면 A하나만 B왼쪽에 위치 B도 하나만 올 수 있음 BAB,AB: O, BABB: X
// -> K가 2라면 ABBA, 
// 모든 A에 대해서 해당 A의 오른쪽에 있는 B의 갯수를 다 더했을때 K가 되면 됨
// 즉 K를 어떤 수의 합으로 표현하면 된다.
// K: 3 -> 3 + 0: ABBB, 2 + 1: ABAB
// BAABBABAAB: AABBBB
// N = 10 K=12 (12,0), (11,1), (10,2), (7,5), ,(4,4,2,1,1), (5,3)
// N=3 K=2
// ABBBBBBBBABB
// AB*12 B:12 A:1
// AB*10B*1 B:11 A:2
// AB*2AB*5 B:7 A:2

// N = 5 K = 1 (1,0)
// BBBAB
// N=12 K=27
// A하나 B 최대 11 1*11
// A두개 B최대 20  2*10
// A세개 B최대 27  3*9
// A네게 B최대 32  4*8
//           35  5*7
