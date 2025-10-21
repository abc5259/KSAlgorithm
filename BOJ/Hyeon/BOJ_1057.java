package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int han = Integer.parseInt(st.nextToken());

        int round = 0;

        while (jimin != han) {
            jimin = (jimin + 1) / 2;
            han = (han + 1) / 2;

            round++;
        }
        System.out.println(round);
    }
}
// S4 토너먼트 브루트포스
// 30분
// 이거 2의 제곱으로 접근했는데 그 정수 나누기였다.
// 계속해서 반복