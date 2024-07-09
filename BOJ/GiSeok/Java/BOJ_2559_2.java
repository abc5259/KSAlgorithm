/**
 * 2559 - 수열
 * 누적합, 실버3, 시도
 * 슬라이딩 윈도우의 경우 시간 복잡도가 25억 가까이 나온다.
 * 누적합으로 풀 경우 N + N = 10만 + 10만 = 20만
 * 엄청 줄어드네
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] psum = new int[N + 1];

        psum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            psum[i] = psum[i - 1] + Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++)
            if (psum[i] - psum[i - K] > max) max = psum[i] - psum[i - K];

        System.out.println(max);
    }
}
