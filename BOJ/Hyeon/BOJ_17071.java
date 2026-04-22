package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17071 {
    static final int MAX = 500_000;
    static int N, K;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        visit = new boolean[2][MAX + 1];

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visit[0][N] = true;

        int time = 0;

        while (!queue.isEmpty()) {
            K += time;

            if (K > MAX) {
                return -1;
            }

            if (visit[time % 2][K]) {
                return time;
            }

            int size = queue.size();
            int mod = (time + 1) % 2;

            for (int s = 0; s < size; s++) {
                int cur = queue.poll();

                int[] pos = {cur - 1, cur + 1, cur * 2};

                for (int next : pos) {
                    if (next < 0 || next > MAX || visit[mod][next]) {
                        continue;
                    }
                    queue.offer(next);
                    visit[mod][next] = true;
                }
            }
            time++;
        }
        return -1;
    }
}
// P5 숨바꼭질 5 BFS
// 1시간
// 수빈이는 + 1했다가 -1 하면 제자리에 있을 수 있음 즉 2초 단위로 위치를 고정할 수 있다.
// 그래서 1초에 1에 위치하면 3초 5초 7초에 다 가능함. 그래서 가지치기로 visit[짝수 홀수][동생위치] 해서 값이 true 면 탈출
// 이게 time 단위로 bfs 가 돌아가기 때문에 time 마다 queue의 사이즈만큼 반복시켜준다
// 그리고 끝나면 time+1 해줌