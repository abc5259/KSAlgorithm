package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '#') {
                    grid[i][j] = 0;
                    cnt++;
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
                            if (grid[ny][nx] == '#') {
                                grid[ny][nx] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
}
// S5 Best Grass 구현
// 12분
// 리트코드 느낌처럼 영어로 된 문제 한번 풀어봤는데 쉬운문제였음
// R C가 100이하라서 시간복잡도 문제없었고 4방향 벡터로 시간복잡도 고려했다.
// 잔디에 대한 grid 를 입력받고 잔디가 나오면 이어진 잔디의 개수를 구해서 4방향벡터로 찾고
// 잔디를 찾으면 0으로 채워서 잔디를 없애버리면된다 반복문에서 또 안찾게.