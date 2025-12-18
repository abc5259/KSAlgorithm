package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static int F;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        dist = new int[F + 1];
        Arrays.fill(dist, -1);

        bfs(S, G, U, D);

        System.out.println(dist[G] != -1 ? dist[G] : "use the stairs");
    }

    static void bfs(int from, int to, int up, int down) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(from);
        dist[from] = 0;

        int[] move = {up, -down};

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int dis : move) {
                int now = poll + dis;

                if (now > 0 && now <= F && dist[now] == -1) {
                    queue.offer(now);
                    dist[now] = dist[poll] + 1;
                    if (now == to) {
                        return;
                    }
                }
            }
        }
    }
}
// S1 스타트링크 BFS
// 13분
// 문제보자마자 BFS 라고 생각
// U 와 D 로만 갈 수 있고 각 이동마다 횟수를 1로 따지는 가중치가 같은 문제
// 범위는 1 ~ F 였고 내 현재가 목표가 될때까지 하기에
// bfs에 탈출 조건 과 시작 넣어주고 반복하고 2가지는 각각의 코드로 해서 시작했다.
// 최초로 도착하는 곳이 최단 횟수임을 인지하는 문제.
// 2가지 방향이라 그냥 반복문으로 배열만들어서 비교