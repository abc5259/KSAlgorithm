package BOJ.Hyeon;

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

        for (int c = 0; c <= N + diff; c++) {
            if (!canPress(c, problem)) continue;
            int len = digitCount(c);
            int presses = len + Math.abs(c - N);
            answer = Math.min(answer, presses);
        }

        System.out.print(answer);
    }

    private static boolean canPress(int c, boolean[] broken) {
        if (c == 0) return !broken[0];
        while (c > 0) {
            if (broken[c % 10]) return false;
            c /= 10;
        }
        return true;
    }

    private static int digitCount(int c) {
        if (c == 0) return 1;
        int cnt = 0;
        while (c > 0) {
            cnt++;
            c /= 10;
        }
        return cnt;
    }
}