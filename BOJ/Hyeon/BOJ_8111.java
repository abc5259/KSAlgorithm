package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_8111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(bfs(N)).append("\n");
        }
        System.out.print(sb);
    }

    static String bfs(int n) {
        int[] parent = new int[n];
        char[] choice = new char[n];
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();

        int start = 1 % n;
        visited[start] = true;
        parent[start] = -1;
        choice[start] = '1';
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == 0) {
                StringBuilder res = new StringBuilder();
                int curr = 0;

                while (curr != -1) {
                    res.append(choice[curr]);
                    curr = parent[curr];
                }
                return res.reverse().toString();
            }

            int[] nextRem = {(cur * 10) % n, (cur * 10 + 1) % n};
            char[] nextChar = {'0', '1'};

            for (int i = 0; i < 2; i++) {
                int next = nextRem[i];

                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    choice[next] = nextChar[i];
                    queue.offer(next);
                }
            }
        }

        return "BRAK";
    }
}
// P5 0과 1 BFS
// 45분
// 길이가 100자리까지 커질 수 있어서 String이나 BigInteger를 큐에 넣어가며 탐색하면 터짐
// 그래서 BFS를 돌릴 때 (현재 나머지 * 10) % n 이랑 (현재 나머지 * 10 + 1) % n 공식을 이용해서
// 0부터 n-1까지의 나머지 값만 큐에 넣고 방문 처리
// 역추적 위해 parent 배열로 이전 나머지 값 기록한다음
// choice 배열로 그때 0을 붙였는지 1을 붙였는지
// 나머지가 0이 되면 찾은거니까 거기서부터 parent 배열 타고 역추적해서 문자를 붙여서 마지막에 reverse() 해주면 끝