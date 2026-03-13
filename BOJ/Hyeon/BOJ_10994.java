package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10994 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int s = (N - 1) * 4 + 1;

        map = new char[s][s];

        for (int i = 0; i < s; i++) {
            Arrays.fill(map[i], ' ');
        }

        draw(0, 0, N);

        StringBuilder sb = new StringBuilder();

        for (char[] row : map) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void draw(int y, int x, int N) {
        if (N == 1) {
            map[y][x] = '*';
            return;
        }
        int s = (N - 1) * 4 + 1;

        for (int i = 0; i < s; i++) {
            map[y][x + i] = '*';
            map[y + i][x] = '*';
            map[y + i][x + s - 1] = '*';
            map[y + s - 1][x + i] = '*';
        }

        draw(y + 2, x + 2, N - 1);
    }
}
// S4 별 찍기 - 19 재귀
// 11분
// 걍 풀었다 운좋게 접근법이 바로 생각났음
// 1,2,3,4 의 테케를 보니까 한 줄의 값이 N-1 * 4 + 1 이고 1이 기저사례로 탈출하길래 재귀를 쓸 수 있겠다 생각했다
// 그래서 s 번 만큼 반복해서 별을 그리고 그 테두리만 별을 남기기위해 +1 부터 -1 칸의 곳에 별을 다 지워버린다
// 그렇게 반복해서 N이 1이면 별을 그리고 탈출한다.
// 개선 풀이
// 각 방향 별로 1개씩 칠해서 s 번 반복해도됨 처음에 다 빈칸으로 초기화하고