package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1166 {
    static int N, L, W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        double min = Math.min(L, Math.min(W, H));

        System.out.println(upperBound(min));
    }

    static double upperBound(double min) {

        double lo = 0;
        double hi = min + 1;

        for (int i = 0; i < 100; i++) {
            double mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static boolean check(double mid) {

        long countL = (long) (L / mid);
        long countW = (long) (W / mid);
        long countH = (long) (H / mid);

        double res = (double) countL * countW * countH;

        return res >= N;
    }
}
// S3 선물 이분탐색
// 45분
// 일단 풀었다
// 최대값 A 를 구하는데 이는 실수이고 더해서 0 부터 Min 까지 가능했다 그래서 범위를 0부터 min +1 로 잡았고
// TTTT FFFF 형태를 따랐다 가장 큰 A 를 구하니까 가장 끝의 T를 구했다 그래서 가능한 lo 를 T로 잡고 절대 안되는 값을
// hi 로 min + 1로 해서 했다.
// 아니 실수형으로 나오길래 나는 정수로만 풀어봐서 lo + 1 < hi 에 익숙해져서 도저히
// 52.40000003 과 같은 실수형을 고려못했다 근데 while 대신 for 문으로 실수형을 계속 돌려서 100정도의 깊이는 끝과 같다는것을 알아서
// 100 반복문으로 하고 check 를 통해서 L,W,H 의 값을 연산하는데 각 10억까지 가능해서 10억의 3승을 하자니 long 도 초과라서 누적 곱 안하고
// 각각의 long 의 값을 double 로 연산해서 res 를 가져서 N 보다 크거나 같은것에 대해 lo 를 올렸다