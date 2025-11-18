package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1963 {
    static boolean[] isPrime;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makePrime();

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        dist = new int[10000];

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            Arrays.fill(dist, -1);

            bfs(from, to);

            if (dist[to] != -1) {
                sb.append(dist[to]);
            } else {
                sb.append("Impossible");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start, int end) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == end) {
                return;
            }

            String s = String.valueOf(poll);

            for (int i = 0; i < 4; i++) {
                char[] numArr = s.toCharArray();

                for (char c = '0'; c <= '9'; c++) {
                    if (i == 0 && c == '0') {
                        continue;
                    }
                    if (numArr[i] == c) {
                        continue;
                    }
                    numArr[i] = c;

                    int num = Integer.parseInt(String.valueOf(numArr));

                    if (dist[num] == -1 && isPrime[num]) {
                        queue.offer(num);
                        dist[num] = dist[poll] + 1;
                    }
                }
            }
        }
    }

    static void makePrime() {
        isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
// G4 소수 경로 BFS
// 45분
// 복습인데도 어려웠음
// 일단 차근 차근 정리를 해보자면 내가 시작 하는 값에서 부터 도착값 까지 정해져있고 이 사이에는 다 소수여야된다
// 그래서 4자리의 수에서 1자리씩 바꿔서 이를 큐에 넣고 플러드 필처럼 늘려나간다
// 가중치는 모두 횟수 1이기에 BFS라고 생각
// 도착 값에 최초로 도착했을 경우의 횟수가 최소값을 가지기 때문
// 그래서 방문여부를 도착횟수로 두고 하려고 하는데 이까지는 다 괜찮았는데 주요한 로직은

// 1. 4자리 소수 A에서 B로 바꾸는데, 한 번에 한 자리씩만 바꿈
// 2. 바꾸는 과정에서 나오는 숫자들도 모두 소수
// 3. 최소 변경 횟수를 구해야 하므로 가중치가 1인 그래프의 최단 경로 문제 -> BFS

// mod 연산 대신 String.valueOf()와 toCharArray() 사용
// 구현 실수를 줄이고 직관적으로 자릿수를 변경함
