package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dpMin = new int[N + 1][4];
        int[][] dpMax = new int[N + 1][4];

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                dpMin[i][j] = Integer.parseInt(st.nextToken());
                dpMax[i][j] = dpMin[i][j];
            }
        }

        for (int i = 2; i <= N; i++) {
            dpMin[i][1] += Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);
            dpMin[i][2] += Math.min(dpMin[i - 1][1], Math.min(dpMin[i - 1][2], dpMin[i - 1][3]));
            dpMin[i][3] += Math.min(dpMin[i - 1][2], dpMin[i - 1][3]);

            dpMax[i][1] += Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);
            dpMax[i][2] += Math.max(dpMax[i - 1][1], Math.max(dpMax[i - 1][2], dpMax[i - 1][3]));
            dpMax[i][3] += Math.max(dpMax[i - 1][2], dpMax[i - 1][3]);
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            if (dpMin[N][i] < min) {
                min = dpMin[N][i];
            }
            if (max < dpMax[N][i]) {
                max = dpMax[N][i];
            }
        }
        System.out.println(max + " " + min);
    }
}
// G5 내려가기 DP
// 다시 풀었는데 너무 쉽게 풀었다
// 그냥 슬라이딩 윈도우라는데 인덱스간의 최소값과 최대값의 DP 를 2개 배열해서 했더니 용량은 얼추 4MB였다.
// 그런데 문제는 256 이어서 공간을 초과하지는 않았지만 이렇게 쉽게 풀 수 있엇다. 그리고 문제는 슬라이딩 윈도우라고 해서
// 그렇게 하는건 어떤가 생각했더니 그냥 값으로 가지고 있으면된다. 배열로 전체가 필요한게 아닌
// 최소의 3개와 최대의 3개의 변수만 있으면 O(1) 으로 쓸 수 있고 이를 갱신하면서 더해주면된다 DP 를 통해서