package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] square = new int[N][2];

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            square[i][0] = Integer.parseInt(st.nextToken());
            square[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(max, square[i][1]);
        }

        Arrays.sort(square, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = 0;
        for (int i = 0; i < N; i++) {
            if (square[i][1] == max) {
                start = i;
            }
        }

        int X = square[0][0];
        int Y = square[0][1];

        // 제일 큰거 기준으로 합산 그래서 제일큰거 먼저넣고
        int sum = max;

        // 제일큰거 까지 왼쪽부터 큰거나오면 그만큼 넓이 누적으로 더해서 제일큰애전까지
        for (int i = 0; i <= start; i++) {
            if (square[i][1] >= Y) {
                sum += (square[i][0] - X) * Y;
                X = square[i][0];
                Y = square[i][1];
            }
        }
        // 제일 큰거까지 오른쪽부터 큰거나오면 그만큼 넓이 누적으로 더해서 제일 큰애전까지
        X = square[N - 1][0];
        Y = square[N - 1][1];

        for (int i = N - 1; i >= start; i--) {
            if (square[i][1] >= Y) {
                sum += (X - square[i][0]) * Y;
                X = square[i][0];
                Y = square[i][1];
            }
        }
        System.out.println(sum);
    }
}
// S2 창고 다각형 스택X 브루트
// 아니 스택문제라서 풀었더니 브루트로 풀었다.
// 가장 큰 높이를 기준으로 제일 왼쪽에서 , 제일 오른쪽에서 가장 큰쪽으로 가듯 풀었다.
// 이전 높이를 기준으로 누적합으로 계산한다.