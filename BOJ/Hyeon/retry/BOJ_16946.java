package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_16946 {
    static int N, M;
    static int[][] map;
    static int[][] number;
    static HashMap<Integer, Integer> cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = c[j] - '0';
            }
        }
        number = new int[N][M];
        cnt = new HashMap<>();

        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (number[i][j] == 0 && map[i][j] == 0) {
                    cnt.put(num, bfs(i, j, num));
                    num++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    HashSet<Integer> containNum = new HashSet<>();

                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= M || number[ny][nx] == 0) {
                            continue;
                        }
                        if (containNum.contains(number[ny][nx])) {
                            continue;
                        }
                        map[i][j] += cnt.get(number[ny][nx]);
                        containNum.add(number[ny][nx]);
                    }
                    map[i][j] %= 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] line : map) {
            for (int val : line) {
                sb.append(val);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x, int num) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        number[y][x] = num;

        int size = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || number[ny][nx] != 0) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                    number[ny][nx] = num;
                    size++;
                }
            }
        }
        return size;
    }
}
// G2 벽 부수고 이동하기 4 BFS 최적화
// 21분(시간초과) + 1시간 10
// 문제를 이해하는데 좀 오래걸렸는데 그냥 쉽게생각하면
// 가중치가 1인 값을 가지는 행렬 그래프에서 벽의 좌표에서 해당 벽을 깻을 경우 갈 수 있는 최대의
// 섬의 개수를 가진 다 이를 반복하여 모든 벽들에서 해당 벽을 깼을 때의
// 갈 수 있는 가짓수를 반환하는 문제이다.
// trouble shooting
// 벽마다 모든 BFS 를 돌려버리면 이미 방문 했던 빈칸을 무수히 많이 반복하기 때문에
// 예를들어 1000개 1000개 행렬에서 벽이 50만개 있으면 BFS 는 50만 번 돌린다음에
// 50만번 벽이 아닌곳을 방문해서 시간 초과가 발생한다.
// 그래서 빈공간 별로 번호를 붙이고 해당 번호와 인접할 경우 그 빈공간의 값을 map 의 개수와 연산해서가진다
// 그래서 처음에 빈공간에 대해서 bfs 를 돌려서 각 빈공간의 번호를 각 좌표마다 넣어서
// number 라는 배열안에 각 좌표의 번호를 저장하고
// bfs 를 돌리고 나서 빈공간의 총 개수를 반환하여 이를
// 번호, 개수 라는 HashMap 에 put 한다.
// 그리고 벽들에 있어서 벽의 상하좌우에 빈공간의 개수으 ㅣ합을 구하는데
// 이때 이미 내가 구한 값을 다른 방향에서도 접근한다면 안되기때문에 Set 을 통해서 중복을 잡아낸다.