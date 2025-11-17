package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        String[] tmp = new String[3];

        String min = "";

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                tmp[0] = str.substring(0, i);
                tmp[1] = str.substring(i, j);
                tmp[2] = str.substring(j);

                StringBuilder sb1 = new StringBuilder(tmp[0]);
                StringBuilder sb2 = new StringBuilder(tmp[1]);
                StringBuilder sb3 = new StringBuilder(tmp[2]);

                String res = sb1.reverse().toString() + sb2.reverse() + sb3.reverse();

                if (min.isEmpty()) {
                    min = res;
                } else if (res.compareTo(min) < 0) {
                    min = res;
                }
            }
        }
        System.out.print(min);
    }
}
// S5 단어 나누기 문자열, 완전 탐색
// 30분
// 일단 생각하는 게 조금 애매 했다 기초적인 문제 복습 필
// substring 으로 하고 2개의 구간을 잘라서 2 중 반복문 쓰는거 까지 맞았고
// 또 잘라진 부분을 가변 객체로 만들어서 reverse 를 통해 문자열을 만들고 문자열 연산을 통해서
// 3개의 잘라지고 뒤집어진 문자열을 이어서 붙인다음에 이를
// 문자열 비교연산으로 compareTo 로 해서 처리한다. 이때 음수를 반환하면 앞의 비교하는 수가 더 작은것이므로
// res 를 최종으로 min 에 대입한다
// 근데 또 다른 방식으로는 저런 문자열들을 모두 list 에 넣어서 이를 Collection 정렬해버려도된다.