package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static int N, K;
    static final int MAX = 100_001;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[MAX];

        Arrays.fill(time, MAX);

        bfs();
    }

    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int point = queue.poll();

            if (point == K) {
                System.out.print(time[point]);
                return;
            }

            if (point * 2 < MAX && time[point * 2] == MAX) {
                queue.offerFirst(point * 2);
                time[point * 2] = time[point];
            }
            if (point - 1 >= 0 && time[point - 1] == MAX) {
                queue.offerLast(point - 1);
                time[point - 1] = time[point] + 1;
            }
            if (point + 1 < MAX && time[point + 1] == MAX) {
                queue.offerLast(point + 1);
                time[point + 1] = time[point] + 1;
            }
        }
    }
}
// G5 숨바꼭질 3 0,1 BFS
// trouble
// 이게 BFS 문제인데 가중치가 달라서 나는 이걸 어떻게 할까 고민을 했는데 생각해보니
// 양방향 큐를 써서 2배 진행하는거부터 선점을 해버리면 된다
// 그래서 선점하면 끝나기에 poll 햇을 때 값이 K 랑 같으면끝내도된다
// 근데 이제부터가 중요하다
// 비용이 1이랑 0이 있기 때문에 0,1 BFS 라고 한다 그래서 그래서 0부터 넣어줘야돼서 양방향 큐의 offerFirst 와 Last 를 사용한다
// 가장 시간이 적게 걸린거부터 하기 떄문에
//  - 부터 하고 나서 + 를 해야된다.