package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 100) {
            System.out.println(0);
            return;
        }
        int M = Integer.parseInt(br.readLine());

        boolean[] problem = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                problem[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int diff = Math.abs(N - 100);
        int answer = diff;

        for (int i = 0; i <= N + diff; i++) {
            if (!canPress(i, problem)) {
                continue;
            }
            int len = digitCount(i);
            int presses = len + Math.abs(i - N);
            answer = Math.min(presses, answer);
        }
        System.out.println(answer);
    }

    static boolean canPress(int c, boolean[] problem) {
        if (c == 0) {
            return !problem[0];
        }
        while (c > 0) {
            if (problem[c % 10]) {
                return false;
            }
            c /= 10;
        }
        return true;
    }


    static int digitCount(int num) {

        if (num == 0) {
            return 1;
        }

        int cnt = 0;
        while (num > 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}

// G4 리모컨 브루트포스
// 경우의수를 나눠서 비교 다시 도전해보자