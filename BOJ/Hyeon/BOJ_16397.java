package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16397 {
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        cnt = new int[100_000];
        Arrays.fill(cnt, -1);

        bfs(N, T, G);

        System.out.println(cnt[G] == -1 || cnt[G] > T ? "ANG" : cnt[G]);
    }

    static void bfs(int start, int T, int end) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        cnt[start] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == end) {
                return;
            }

            if (cnt[poll] >= T) {
                return;
            }

            if (poll + 1 <= 99999 && cnt[poll + 1] == -1) {
                queue.offer(poll + 1);
                cnt[poll + 1] = cnt[poll] + 1;
            }

            if (poll > 0 && poll * 2 <= 99999) {
                int tmp = poll * 2;
                int diff = 1;

                while (tmp >= 10) {
                    tmp /= 10;
                    diff *= 10;
                }
                tmp = poll * 2 - diff;

                if (cnt[tmp] == -1) {
                    queue.offer(tmp);
                    cnt[tmp] = cnt[poll] + 1;
                }
            }
        }
    }
}
// G4 탈출 BFS
// 27분
// 일단 최단 시간을 구하는 문제 그리고 방문 여부를 통해서 내가 가장 빨리 가는것을 비교
// + 와 * 에 대한 A 및 B 버튼 모두 가중치가 1 단계로 BFS를 고려했다
// 또 주어진 T 값 이내의 횟수 조건과 N부터 G 로 가는 거리이기에 BFS 확정
// 그런데 내가 자릿수 즉 B 버튼을 다루는 과정에서 - 연산을 하는데 이때 께속 ArrayIndexOutOfBounds 가 발생
// 이유는 내가 10 - 10 해서 0인덱스일 때 N이 0일때를 계산해서 그렇다
// N이 0이면 B 버튼 동작 X 즉 N은 0보다 커야 B 버튼 가능하다는 조건 >0을 넣어서 해결 나머지는 그냥간단한 BFS였다.
// 시작횟수 0 그래서 -1로 초기화 방문여부 int 로 개수 반환