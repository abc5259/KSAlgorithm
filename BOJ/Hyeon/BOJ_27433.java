package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fact(N));
    }

    private static long fact(int N) {
        if (N <= 1) {
            return 1;
        }
        return N * fact(N - 1);
    }
}

// B5 팩토리얼 2 재귀
// 걍 풀었다 1분만에