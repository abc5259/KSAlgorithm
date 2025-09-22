package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        System.out.print(lowerBound(N));
    }

    static long lowerBound(long N) {

        long lo = 0;
        long hi = N;

        while (lo + 1 < hi) {
            long mid = (hi - lo) / 2 + lo;

            if (Math.pow(mid, 2) >= N) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}
// S4 정수 제곱근 이분탐색 + 오버플로우 야기
// Math.sqrt 가 부동소수점 문제로 소수점 이하를 버리기 때문에 값이 달라진다
// 정수 연산만으로 돌려서 고민
// 근데 mid * mid 이거느 long 타입이므로 범위가 오버된다.
// 그래서 double 로 형변환해서 하다가 그냥 Math.pow 를 사용햇다 어차피 반환값이 double 이니까
// 형변환과 오버플로우를 야기할 중요한 문제 접근은 쉽지만 까다로운 문