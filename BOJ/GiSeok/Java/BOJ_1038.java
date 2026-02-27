package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1038 {

    static int ans = 0;
    static Deque<Integer> q = new ArrayDeque<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if (n < 10) {
            System.out.println(n);
            return;
        }
        ans += 9;
        for (int jari = 1; jari < 10; jari++) {
            for (int prev = 1; prev <= 9; prev++) {
                q = new ArrayDeque<>();
                q.push(prev);
                r(jari, prev);
            }
        }

        System.out.println(-1);
    }

    private static void r(int jari, int prev) {
        if (jari == 0) {
            ans++;

            if (ans == n) {
                while (!q.isEmpty()) {
                    System.out.print(q.pollLast());
                }
                System.out.println();
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < prev; i++) {
            q.push(i);
            r(jari - 1, i);
            q.pop();
        }
    }
}
