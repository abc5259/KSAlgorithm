package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int d = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = i;

            while (tmp > 0) {
                if (tmp % 10 == d) {
                    cnt++;
                }
                tmp /= 10;
            }
        }

        System.out.println(cnt);
    }
}
// S5 숫자 빈도수 완전탐색
// 4분
// 걍 읽자마자 바로 이해되고 문제 접근했다 O(n) 만큼 반복된 자연수에서
// d 라는 숫자의 포함된 개수를 구하는거였따 그래서 cnt 라는 변수 따로 빼고
// n 번 반복에 num의 렝스 즉 최대 6 이니까 O(n*6) 으로 해서 시간복잡도는 문제없고 d 와 비교 조건문으로 증가했다.