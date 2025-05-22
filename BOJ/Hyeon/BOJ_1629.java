package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(multiply(A, B));
    }

    static long multiply(long a, long b) {
        if (b == 1) {
            return a % C;
        }
        long l = multiply(a, b / 2) % C;
        long half = l * l % C;
        if (b % 2 == 0) {
            return half;
        } else {
            return half * a % C;
        }
    }
}

// S1 곱셈 분할정복
// 분할정복답게 1개가 될때까지 기저사례를 찾아서 b가 1이면 그냥 A%C를 리턴해주면되고
// 아니라면 b를 제곱단위로 나아간다고 생각해서 b/2가 홀수면 b/2 * b/2 * a를 해주면되고
// 짝수면 b/2 * b/2만 해주면된다 근데 mod 연산을 유의해야하기에 일단 재귀로
// l이라는 변수에 값을 저장해두고 조건 분기를 통해서 가지면된다.