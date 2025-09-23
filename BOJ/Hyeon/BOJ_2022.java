package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2022 {
    static final double EPS = 1e-4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double lo = 0;
        double hi = Math.min(x, y);

        while (hi - lo > EPS) {
            double mid = (hi - lo) / 2.0 + lo;

            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(mid, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(mid, 2));

            double res = h1 * h2 / (h1 + h2);

            if (res >= c) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        System.out.printf("%.3f", lo);
    }
}
// G4 사다리 이분탐색
// 이게 실수 버전 이분탐색이다
// 정수에서는 lo 와 hi 를 lo + 1 < hi 로 해서
// lo + 1 == hi 까지 반복문을 돌렸는데
// 실수 버전에서는 hi 와 lo 의 차이가 EPS 보다 작은 수일 때까지 반복해서 탈출조건을 사용했다
// 그리고 삼각형의 닮음 을 푼 풀이답게 sqrt 랑 pow 를 써서 해결했다.