package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visit;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int date = 0;

        while (true) {
            boolean isMove = false;
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        int sum = bfs(i, j);

                        if (list.size() > 1) {
                            isMove = true;
                            int tmp = sum / list.size();
                            for (int[] pair : list) {
                                A[pair[0]][pair[1]] = tmp;
                            }
                        }
                    }
                }
            }
            if (!isMove) {
                break;
            }
            date++;
        }
        System.out.println(date);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;
        list = new ArrayList<>();

        list.add(new int[]{y, x});
        int sum = A[y][x];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
                    continue;
                }
                int diff = Math.abs(A[ny][nx] - A[cy][cx]);

                if (L <= diff && diff <= R) {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;

                    list.add(new int[]{ny, nx});
                    sum += A[ny][nx];
                }
            }
        }
        return sum;
    }
}
// G4 인구 이동 BFS
// 1시간 7분 어렵다.
// 일단 N X N 땅이고 인구 이동하는데에 있어서 가중치는 모두 일치한다 왜냐?
// 사람을 이동하는건 이게 가중치랑 별개이고 해당 L과 R에 맞는 범위를 가지고 있다면 다 이동할 수 있기 때문이다
// 그래서 일단 bfs를 반복해야된다 L이랑 R의 조건에 통과 안될 때까지
// 그래서 BFS 를 반복문 내에 넣어야하고 그 반복문은 슬라이딩 윈도우로 해서
// 1개도 인구이동 할 도시가 없게 하면되니까,,
// 그리고 bfs 돌때마다 갈 수 있는 국경선까지해서 총 인구의 합을 리턴한다
// 그래서 내가 갈 수 있는 곳까지의 인원 합과 그 인원들의 좌표를 list 에 담아서
// list 의 크기로 국가의 수를 계산해서 나눈다음 다시 A 배열에 대입해주고 이를 반복
// 개선 풀이
// 일단 나는 while 반복문을 국경선이 허물어지는 곳이 있는지 확인하고 나서 들어가서 bfs 를 돌렸는데
// 차라리 bfs 를 돌리면서 검사하는게 이중으로 비용이 들지않아서 합쳤다