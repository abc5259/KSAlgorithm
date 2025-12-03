package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_9019 {
    static int B;
    static final int LIMIT = 10_000;
    static Pair[] tracking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            tracking = new Pair[LIMIT];

            bfs(A);

            while (tracking[B].command != '0') {
                sb.append(tracking[B].command);
                B = tracking[B].idx;
            }
            System.out.println(sb.reverse());
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        tracking[start] = new Pair(0, '0');

        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == B) {
                return;
            }

            // D
            int D = (n * 2 % LIMIT);
            if (tracking[D] == null) {
                queue.offer(D);
                tracking[D] = new Pair(n, 'D');
            }

            // S
            int S = n - 1;
            if (S < 0) {
                S = 9999;
            }
            if (tracking[S] == null) {
                queue.offer(S);
                tracking[S] = new Pair(n, 'S');
            }

            // L
            int L = (n % 1000) * 10 + (n / 1000);

            if (tracking[L] == null) {
                queue.offer(L);
                tracking[L] = new Pair(n, 'L');
            }

            // R
            int R = (n % 10) * 1000 + (n / 10);
            if (tracking[R] == null) {
                queue.offer(R);
                tracking[R] = new Pair(n, 'R');
            }
        }
    }

    static class Pair {
        public int idx;
        public char command;

        public Pair(int idx, char command) {
            this.idx = idx;
            this.command = command;
        }
    }
}
// G4 DSLR BFS 역추적
// 1시간
// 최단거리 를 통해서 역추적 하는 문제 였다
// 가중치는 어차피 모두가 동일하기 떄문에 주어진 A 에서 B까지의 최단 거리를 구하고자 한다.
// 그래서 BFS 를 통해서 플러드필로 나아가고 B와 poll 한 값이 같을때 탈출 조건을 실행한다
// L과 R에 대해서 문제라고 생각했는데 비트마스킹으로 풀려고 했는데 주어진 문제가
// 10진수 0 ~9999라서 사칙연산으로도 실행했다
// 비트마스킹은 이진수만 취급하기 때문에
// 방문 여부를 판단해야 하며 또 이전의 방문 값과 방법을 기억해야 되기 때문에
// 2개의 값을 가지는 Pair 클래스를 통해서 역추적 배열을 만들어서
// 인덱싱 해서 반복문으로 조회하였다.