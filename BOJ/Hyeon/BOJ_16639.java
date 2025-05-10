package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16639 {
    static int N, max;
    static char[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        op = br.readLine().toCharArray();

        max = Integer.MIN_VALUE;
        dfs(0, 0);

        System.out.print(max);
    }

    static void dfs(int idx, int total) {
        if (idx >= N) {
            return;
        }

    }

    static int cal(int i, int j, char op) {
        switch (op) {
            case '+':
                return i + j;
            case '-':
                return i - j;
            default:
                return i * j;
        }
    }
}

// G1 괄호 추가하기 2 dfs 실패
// dfs로 하기엔 경우의 수가 너무 많다.
// 괄호가 중첩될 수 있고 기본 연산자 우선순위도 있고 연산자 개수 최대 9개
// 중첩허용하면 dfs로 안되고 시간초과 발생한다.