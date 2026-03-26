package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
    static int fromX, fromY, toX, toY;
    static Store[] stores;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            fromX = Integer.parseInt(st.nextToken());
            fromY = Integer.parseInt(st.nextToken());

            stores = new Store[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                stores[i] = new Store(x, y);
            }

            st = new StringTokenizer(br.readLine());

            toX = Integer.parseInt(st.nextToken());
            toY = Integer.parseInt(st.nextToken());

            visit = new boolean[n];

            if (bfs()) {
                sb.append("happy");
            } else {
                sb.append("sad");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs() {
        Queue<Store> queue = new ArrayDeque<>();
        queue.offer(new Store(fromX, fromY));

        while (!queue.isEmpty()) {
            Store poll = queue.poll();

            int cx = poll.x;
            int cy = poll.y;

            if (Math.abs(cx - toX) + Math.abs(cy - toY) <= 1000) {
                return true;
            }

            for (int i = 0; i < stores.length; i++) {
                if (Math.abs(cx - stores[i].x) + Math.abs(cy - stores[i].y) <= 1000) {
                    if (visit[i]) {
                        continue;
                    }
                    queue.offer(stores[i]);
                    visit[i] = true;
                }
            }
        }
        return false;
    }

    static class Store {
        int x;
        int y;

        Store(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
// G5 맥주 마시면서 걸어가기 BFS
// 56분
// 그리디로 45분 동안 풀다가 반례 찾고 엎었음..