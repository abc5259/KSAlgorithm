package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String ans = "UCPC";
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (cnt == 4) {
                break;
            }
            if (str.charAt(i) == ans.charAt(cnt)) {
                cnt++;
            }
        }
        if (cnt == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
// S5 UCPC는 무엇의 약자일까? 그리디
// 먼저 주어진 문자열의 길이를 전체 탐색하는 반복문 내에서
// UCPC 라는 문자열을 ans로 설정해둔다. 그다음
// 그다음 cnt를 UCPC 문자열의 index로 설정해둬서 이 해당 인덱스가 4라는 UCPC의
// 인덱스의 3 범위를 초과하면 바로 break를 통해서 UCPC 문자열을 만들 수 있다는 것을 하면되고
// 아니면 Hate 하면된다.