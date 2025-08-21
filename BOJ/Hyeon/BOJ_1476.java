package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;

        while (((year - E) % 15 != 0) || ((year - S) % 28 != 0) || ((year - M) % 19 != 0)) {
            year++;
        }
        System.out.print(year);
    }
}

// S5 날짜 계산 브루트포스
// 그냥 풀었다 이게 3개의 E S M 에 맞는 최소공배수를 찾는거처럼 되는데
// 완전 탐색으로 반복해도 15와 28 19라는 상한선때문에 시간초과는 발생하지않는다.