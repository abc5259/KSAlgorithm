package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] min = new int[N][3];
        int[][] max = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 3; i++) {
            min[0][i] = max[0][i] = arr[0][i];
        }

        for (int i = 1; i < N; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];
            max[i][1] = Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + arr[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][2];

            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];
            min[i][1] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + arr[i][1];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][2];
        }
        for (int i = 0; i < 2; i++) {
            min[N - 1][i + 1] = Math.min(min[N - 1][i], min[N - 1][i + 1]);
            max[N - 1][i + 1] = Math.max(max[N - 1][i], max[N - 1][i + 1]);
        }
        System.out.println(max[N - 1][2] + " " + min[N - 1][2]);
    }
}

// G5 내려가기 DP
// 슬라이딩 윈도우라는데 그냥 인ㄷ게스끼리 관리하는거 같음