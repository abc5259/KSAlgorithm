package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (checkPath(map[i])) {
                cnt++;
            }
        }

        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            for (int i = 0; i < N; i++) {
                col[i] = map[i][j];
            }
            if (checkPath(col)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean checkPath(int[] line) {
        boolean[] isSlope = new boolean[N];

        for (int i = 0; i < N - 1; i++) {

            if (line[i] == line[i + 1]) {
                continue;
            }
            if (Math.abs(line[i] - line[i + 1]) > 1) {
                return false;
            }
            if (line[i] - line[i + 1] == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || line[i + 1] != line[j] || isSlope[j]) {
                        return false;
                    }
                    isSlope[j] = true;
                }
            } else if (line[i + 1] - line[i] == 1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || line[i] != line[j] || isSlope[j]) {
                        return false;
                    }
                    isSlope[j] = true;
                }
            }
        }
        return true;
    }
}
// G3 경사로 구현 복습 필요
// 1시간 실패
// 반드시 다시 풀기 구현으로 접근했는데 경사로에 판단여부를 파악못했고 또 2번의 반복문으로 행과 열을 검사하려햇는데
// path 라는 배열 하나에 추상화해버려서 코드 중복 개선.