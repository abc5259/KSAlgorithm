package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    static final int LIMIT = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        boolean[] notPrime = new boolean[LIMIT];

        notPrime[1] = true;

        for (int i = 2; i * i < LIMIT; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < LIMIT; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int start = 3;
            int end = n - start;

            while (start <= end) {
                if (!notPrime[start] && !notPrime[end]) {
                    sb.append(n).append(" = ").append(start).append(" + ").append(end).append("\n");
                    break;
                }
                start += 2;
                end -= 2;
            }

            if (start > end) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        System.out.println(sb);
    }
}
// S1 골드바흐의 추측 투 포인터 ,에라토스테네스의 체
// 10분
// 수 판별을 한 후 반복 문을 돌려서 정수 일 때에 대한 탈출 조건