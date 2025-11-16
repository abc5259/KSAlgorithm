package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2210 {
    static int[][] map;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][5];
        set = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "" + map[i][j]);
            }
        }
        System.out.println(set.size());
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x, String num) {
        if (num.length() == 6) {
            set.add(num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) {
                continue;
            }
            dfs(ny, nx, num + map[ny][nx]);
        }
    }
}
// S2 숫자판 점프 DFS
// 15분
// 일단 문제에서 힌트가 많다 인접해 있는 네방향이동 + 한번 거쳤던 칸을 다시 거쳐도 된다 + 격자판 숫자이동
// 그래서 dfs 라고 생각햇다 BFS 는 방문여부를 따져서 갔던 곳은 절대 가면안되니까
// 그래서 dfs 를 돌렸는데 6자리가 되어야 하고 내가 5 * 5 격자판을 움직이기에 각 좌표마다 반복문으로 입력되게 하고
// 처음 문자열을 입력해서 넣고
// dfs 의 기저 사례 탈출 조건은 길이가 6이면 탈출시키게 했다
// 그리고 ny 와 nx 의 좌표에 대해서만 점검후 dfs 로 재귀를 돌렸다.
// trouble shooting
// 나는 문자열을 반환시켜서 dfs는 숫자로된 문자열만 탐색하는 책임과
// 기존의 반복문에서 이를 점검해서 set 하는 책임을 분리한다고 나눴었다.
// 문제점은 기저사례에서 문자열을 반환하고 나면 다시 dfs를 호출했던 곳으로 5자리로 가는데
// for 문이 끝나면 return 에 대해서 "" 가 반환된다
// 그리고 문자열로만 풀어도 ㅇㅋ임