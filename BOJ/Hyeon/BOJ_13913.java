package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13913 {
    static final int LIMIT = 100_001;
    static int[] arr;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 추적
        arr = new int[LIMIT];
        // 거리
        dis = new int[LIMIT];

        Arrays.fill(arr, -1);
        Arrays.fill(dis, -1);

        bfs(N, K);

        System.out.println(dis[K]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(K);

        while (arr[K] != -1) {
            stack.push(arr[K]);
            K = arr[K];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(int start, int from) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dis[start] = 0;

        while (!queue.isEmpty()) {
            int cPoint = queue.poll();

            if (cPoint == from) {
                return;
            }
            int[] moving = {cPoint * 2, cPoint + 1, cPoint - 1};

            for (int i = 0; i < 3; i++) {
                if (moving[i] >= 0 && moving[i] < LIMIT && dis[moving[i]] == -1) {
                    queue.offer(moving[i]);
                    dis[moving[i]] = dis[cPoint] + 1;
                    arr[moving[i]] = cPoint;
                }
            }
        }
    }
}
// G4 숨바꼭질 4 BFS
// 30분
// 일단 최단 시간을 찾는 문제이기도 하고 모든 이동의 비용이 1초다
// 그럼 가중치가 1인 그래프에서 최단 경로를 찾는 곳이다. -> BFS

// arr 으로 부모 노드를 기억해두고
// dis로 방문 여부와 거리를 설정해서
// +1 단위로 퍼져나가는 플로드 홍수를 나타낸다
// 그리고 3개의 다음 포인트를 배열로 만들어서 조건 설정하고
// offer 과 방문 여부까지 다룬다
// 그리고 역추적이기 때문에 stack으로 이용한다.

// trouble shooting
// 0에서 시작하는거를 고려하기 때문에
// dis 와 arr 모두 0으로 초기화 하는게 아니라 -1로 초기화를 해야한다.