package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] floor = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            System.arraycopy(arr, 0, floor[i], 0, M);
        }

        int ans = 0;

        // 행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (floor[i][j] == '-' && floor[i][j + 1] == '-') {
                    while (j < M && floor[i][j] == '-') {
                        floor[i][j++] = '.';
                    }
                    ans++;
                }
            }
        }

        // 열
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (floor[j][i] == '|' && floor[j + 1][i] == '|') {
                    while (j < N && floor[j][i] == '|') {
                        floor[j++][i] = '.';
                    }
                    ans++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (floor[i][j] != '.') {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
// S4 바닥 장식 구현
// 26분
// 그냥 구현으로 풀었다. N 과 M이 50까지 이길래 시간복잡도로 O(NM)이라 생각해도 여유롭다고 판단했다
// 방문 여부 처럼 floor 의 체크를 하고 체크 안된 애들만 ans 개수를 더해서 구했다
// dfs 도 고려는 해봤다.