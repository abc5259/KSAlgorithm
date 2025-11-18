package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13913 {
    static final int LIMIT = 100_001;
    static int[] time, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        time = new int[LIMIT];
        Arrays.fill(time, -1);

        arr = new int[LIMIT];
        Arrays.fill(arr, -1);

        bfs(N, K);

        System.out.println(time[K]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (K != -1) {
            stack.push(K);
            K = arr[K];
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == K) {
                return;
            }
            int[] moving = {poll * 2, poll + 1, poll - 1};

            for (int i = 0; i < 3; i++) {
                if (moving[i] < 0 || moving[i] >= LIMIT || time[moving[i]] != -1) {
                    continue;
                }
                queue.offer(moving[i]);
                time[moving[i]] = time[poll] + 1;
                arr[moving[i]] = poll;
            }
        }
    }
}
// G4 숨바꼭질 4 BFS, 역추적 복습
// 32분
// 자 일단 N 과 K 에 대해서 고 K 까지 갈 수 있는 최단 시간을 구하는 거다
// 그리고 2배와 +1 -1 로 갈 수 있는데 이는 최초 방문이 최소 시간인셈이고 재방문 할 경우 이전 방문이 최단으로 치기때문에
// 그렇다면 이거는 BFS 다 더해서 가중치도 모두 동일하게 1으로 시간을사용한다.
// 그리고 최소 시간과 함께 구해야되는것이 역추적도 필요하다 내가 이때까지 거쳐간 공간이 필요해서 이또한 arr 배열으로 역추적을 저장한다.
// arr 으로 부모 노드를 기억해두고 time 으로 방문 여부와 함께 걸린 시간까지 측정한다.
// +1 단위로 퍼져나가는 플로드 홍수를 나타낸다
// 그리고 3개의 다음 포인트를 배열로 만들어서 조건 설정하고
// offer 과 방문 여부까지 다룬다
// 그리고 역추적이기 때문에 stack으로 이용한다.

// trouble shooting
// 시작과 끝 구간이 모두 0을 포함하기에
// time 과 arr 모두 0으로 초기화하게 된다면 도착이나 시작이 0인경우에는 배제 되기 때문에 -1로 초기화한다.