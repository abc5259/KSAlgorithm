package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static int N, r, c, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);

        z(0, 0);

        System.out.println(res);
    }

    static void z(int y, int x) {
        if (N == 1) {
            return;
        }
        N /= 2;
        if (r < y + N && c < x + N) {
            z(y, x);
        } else if (r < y + N) {
            res += N * N * 1;
            z(y, x + N);
        } else if (c < x + N) {
            res += N * N * 2;
            z(y + N, x);
        } else {
            res += N * N * 3;
            z(y + N, x + N);
        }
    }
}

// G5 Z 분할정복
// 2로 나누어서 4사분면을 가지고 논다.
// 만약 0,0을 기준으로 N만큼 갔을 때 c와 r보다 크면 좌상이 아니고
// 이런식으로 4개의 사분면의 조건을 탐색하면된다
// 숫자의 경우 N * N * 정수 하면된다.
// 예를들면 8을 입력하고 2로 나누어서 4를 들고 있을 때 0,0에서 4씩 더한거보다 r과 c가 더컸으면 좌하 사분면
// 이런곳에 위치 하고 해당 값은 N*N*사분면 0, 1, 2,3부터 시작해서 계싼하면된다.