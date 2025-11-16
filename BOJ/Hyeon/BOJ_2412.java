package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2412 {
    static int T;
    static final int MAX = 1_000_001;
    static ArrayList<Integer>[] adj;
    static HashSet<Integer>[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        adj = new ArrayList[MAX];
        visit = new HashSet[MAX];

        for (int i = 0; i < MAX; i++) {
            adj[i] = new ArrayList<>();
            visit[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
        }
        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visit[0].add(0);

        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int[] poll = queue.poll();
                int cx = poll[0];
                int cy = poll[1];

                if (cy == T) {
                    return cnt;
                }

                for (int i = cx - 2; i <= cx + 2; i++) {
                    if (i < 0 || i >= MAX) {
                        continue;
                    }
                    for (int var : adj[i]) {
                        if (Math.abs(var - cy) <= 2) {
                            if (!visit[i].contains(var)) {
                                queue.offer(new int[]{i, var});
                                visit[i].add(var);
                            }
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
// G4 암벽 등반 BFS
// 1시간 5분
// 일단 n의 5만개의 좌표 입력값이 있고 x의 좌표가 100만 이고 y 좌표가 20만 까지 가능하다는 것에 대해서
// 간선의 수가 훨 적기때문에 이는 희소 그래프 인접리스트를 사용했다.
// 그런데 방문 여부를 매기자니 이동 횟수를 리턴하기 위한 문제라서 2차원 배열로 int 로 해서
// 증가 시키고 싶은데 이는 그러면 공간 복잡도 오버로 메모리 초과가 발생할 거 같았다
// 그래서 내 생각에는 기존의 adj 배열에서 해당 좌표를 offer 하게 되면
// 방문 여부 처리로 remove 를시키려고 했다
// trouble shooting
// 그런데 이러지말고 방문여부를 HashSet 을 통해서 판단한 다음
// bfs 내부에 cnt 라는 지역 변수로증가 시키고
// 또 함수를 cnt 단위로 하게 하기 위해서 queue 의 사이즈로 반복문으로 poll 하면서 관리했다.