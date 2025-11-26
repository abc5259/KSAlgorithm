package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
        }
        System.out.println(bfs(sb.toString()));
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(String start) {
        HashMap<String, Integer> visited = new HashMap<>();

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            String poll = queue.poll();

            if (poll.equals("123456780")) {
                return visited.get(poll);
            }

            int curIdx = poll.indexOf('0');

            int cy = curIdx / 3;
            int cx = curIdx % 3;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= 3 || nx >= 3) {
                    continue;
                }

                int nextIdx = ny * 3 + nx;

                char[] c = poll.toCharArray();

                char tmp = c[curIdx];
                c[curIdx] = c[nextIdx];
                c[nextIdx] = tmp;

                String next = new String(c);

                if (!visited.containsKey(next)) {
                    queue.offer(next);
                    visited.put(next, visited.get(poll) + 1);
                }
            }
        }
        return -1;
    }
}
// G2 퍼즐 BFS
// 55분
// trouble shooting
// 일단 3 X 3 배열을 문자화 시켜서 하는거 까진 했는데 내가 ny, nx 등으로 4방 탐색으로 나가다 보니
// 좌표로 키 값을 가져서 방문 여부를 하려했는데 각 키 마다 퍼즐이 달라져야 되는데 그렇게 되면 배열이 공유 참조되니까
// 이를 해결하기 위해 문자열로 두고 계속해서 배열로 만들었다가 tmp 연산하고
// 그렇게 반복하면서 map 을 통해서 방문 여부 + 이동 횟수 까지 담아서 연산했다
// String 을 키로 두고 하니까 이해가 됐던 문제
// 만약 map 에 없다면 큐에 넣고 돌리고 있으면 무시하게 한다.
// 그리고 연산횟수는 방금 뺀 poll 의 + 1이다 이게
// String 이 불변 객체라서 유의 해야되고 0의 좌표를 찾는것도 indexOf 를 사용했다.