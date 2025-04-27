package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] grid = new char[N][M];
        boolean[][] valid = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
                if (str.charAt(j) == '*') {
                    valid[i][j] = true;
                }
            }
        }
        int cnt = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (grid[i][j] == '*') {

                    int idx = 1;
                    while (true) {
                        if (i - idx < 0 || j - idx < 0 || i + idx >= N || j + idx >= M) {
                            break;
                        }
                        if (grid[i - idx][j] != '*' || grid[i][j - idx] != '*' || grid[i + idx][j] != '*' || grid[i][j + idx] != '*') {
                            break;
                        } else {
                            idx++;
                        }
                    }
                    int size = idx - 1;

                    if (size > 0) {
                        valid[i][j] = false;

                        for (int t = size; t > 0; t--) {
                            valid[i - t][j] = false;
                            valid[i + t][j] = false;
                            valid[i][j - t] = false;
                            valid[i][j + t] = false;
                            cnt++;
                            sb.append(i + 1).append(" ").append(j + 1).append(" ").append(t).append("\n");
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (valid[i][j]) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        sb.insert(0, cnt + "\n");
        System.out.print(sb);
    }
}

// S1 십자가 찾기 브루트포스
// 풀이방식을 문자 격자 2차원 배열과 십자가 검사를 했는지의 방문 2차원 배열을 만들어두고
// * 일때 true로 바꿔서 마지막에 true 가 1개라도 있다면 -1을 출력하게끔한다.
// 2개의 배열을 만들고나서 1,1부터 시작해서 *가 있는 곳을 찾고 거기서 상하좌우를 1씩 움직여본다
// 근데 좌표의 범위를 통과하고 나서는 다음 좌표까지 검사해서 다음좌표에 대한 while 반목문을 구성하고
// idx 만큼의 십자가를 더 만들 수 있어서 이에 대한 개수를 size 변수로 받아서
// size가 0보다 크면 size를 감소시키면서 sb로 출력하고 size 개수에 대한 반복문을 통해서 십자가의 * 를 방문 여부를 체크해준다.