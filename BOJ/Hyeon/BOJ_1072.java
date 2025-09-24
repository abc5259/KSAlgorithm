package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        long Z = (Y * 100L) / X;

        if (Z >= 99) {
            System.out.print(-1);
            return;
        }
        System.out.print(lowerBound(X, Y, Z));
    }

    static long lowerBound(int X, int Y, long Z) {

        long lo = 0;
        long hi = X;

        while (lo + 1 < hi) {
            long mid = (hi - lo) / 2 + lo;

            if (((Y + mid) * 100) / (X + mid) > Z) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}
// S3 게임 이분탐색
// 부동소수점 관련해서 Y / X * 100 이 아니라 Y * 100 / X 여야 된다,,
// 오답노트
// 1. 일단 Z가 99이상인거부터 고려해야된다
// X랑 Y가 같으면 100일거고 99에서 100은 불가능하니까 무조건 Z 가 99이상이면 기저 조건으로 탈출해야된다.
// 2. 백분율 이나 비율 문제는 정수로 연산해야된다. double은 오차가 크고 long으로 오버플로우를 방지해야된다.
// 3. 가정하지말고 hi를 리턴할 때 조건문 말기
// 4. 이분 탐색 범위 설정 전략 증명 기반으로 X 가 hi 의 최대로 설정
// 5. lowerBound FFFF..FTTT 에서 첫번째 T 로 생각
