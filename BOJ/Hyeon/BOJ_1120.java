package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            int tmp = A.length();

            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) == B.charAt(j + i)) {
                    tmp--;
                }
            }
            min = Math.min(min, tmp);
        }
        System.out.println(min);
    }
}
// S4 문자열 슬라이딩 윈도우
// 23분
// 일단 최소값을 구해야되는 거고
// 슬라이딩 윈도우 처럼 풀었다.
// A와 B 문자열의 비교를 할 때 비교 범위를 브루트포스에서 전체 A에서 얼마나 B와 일치하는지가 중요했던 문제라서
// 그냥 비교해서 tmp 의 개수 즉 A에서 같은거만큼 뺀거의 최소값을 구해서 한 것이다.
// 슬라이딩 제어 루프 1. B 에서 비교 시작 -> 2 문자 비교 A의 인덱스 -> 3 최소값 갱