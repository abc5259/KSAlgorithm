package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1389 {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            adj[B].add(A);
        }
        int min = Integer.MAX_VALUE;
        int number = 0;

        for (int i = 1; i <= N; i++) {
            cnt = new int[N + 1];

            Arrays.fill(cnt, -1);

            bfs(i);

            int sum = 0;

            for (int val : cnt) {
                sum += val;
            }

            if (min > sum) {
                min = sum;
                number = i;
            }
        }
        System.out.println(number);
    }

    static void bfs(int num) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        cnt[num] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : adj[poll]) {
                if (cnt[next] != -1) {
                    continue;
                }
                queue.offer(next);
                cnt[next] = cnt[poll] + 1;
            }
        }
    }
}
// S1 케빈 베이컨의 6단계 법칙 BFS
// 20분
// 일단 각자 가지고 있는 친구관계를 통해서 모든 친구를 다 만나야 한다 == 내가 처음 방문한 친구가 최단 거리가 된다
// 즉 BFS 라고 생각
// 가중치도 모두 일치 1로 그래서 했는데
// 방문 여부를 그냥 이동 단계로 해서 -1이 아니면 방문을 했다고 생각했다
// 그래서 각 사람별로 이동횟수의 총합을 구해서 가장 작은 사람의 번호를 리턴하기 위해
// 일단 BFS 를 돌려서 cnt 배열을 채워서 리턴한다음
// main 에서 값을 비교하고 그랬다. N이 100밖에 안되기도 했고
// 또 우리 둘이 친구면 양방향도 친구라해서 양방향이라 생각했고 100 * 100 개의 인물 까지 최대에서
// 관계는 1000개가 최대래서 희소 그래프를 연상해서 ArrayList 배열로 했다
// 근데 고민은 저렇게 반복문 안에서 배열을 채워넣는 것과 리턴받고나서 반복문에서 하는일이 많다 정도.