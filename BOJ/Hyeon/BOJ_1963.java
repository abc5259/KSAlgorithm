package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1963 {
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            cnt = new int[10000];
            Arrays.fill(cnt, -1);

            bfs(from);

            if (cnt[to] == -1) {
                sb.append("Impossible");
            } else {
                sb.append(cnt[to]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        cnt[start] = 0;

        while (!queue.isEmpty()) {
            int currentNum = queue.poll();

            int[] jari = new int[4];

            jari[0] = currentNum / 1000;
            jari[1] = (currentNum % 1000) / 100;
            jari[2] = (currentNum % 100) / 10;
            jari[3] = currentNum % 10;

            for (int i = 0; i < 4; i++) {
                int par = (int) Math.pow(10, 4 - i - 1);
                int remain = currentNum - (jari[i] * par);
                for (int j = 0; j < 10; j++) {
                    int tmp = j * par + remain;

                    if (tmp < 1000 || tmp > 9999) {
                        continue;
                    }
                    if (cnt[tmp] != -1) {
                        continue;
                    }

                    if (isPrime(tmp)) {
                        queue.offer(tmp);
                        cnt[tmp] = cnt[currentNum] + 1;
                    }
                }
            }
        }
    }

    static boolean isPrime(int val) {
        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// G4 소수 경로 BFS
// 걍 풀었다.. 어려웠는데 또 좋은 문제 접근해보고싶다.
