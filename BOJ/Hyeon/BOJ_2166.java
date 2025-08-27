package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] node = new int[N + 1][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[i][0] = x;
            node[i][1] = y;
        }
        node[N][0] = node[0][0];
        node[N][1] = node[0][1];

        long sumA = 0, sumB = 0;
        for (int i = 0; i < N; i++) {
            sumA += (long) node[i][0] * node[i + 1][1];
            sumB += (long) node[i][1] * node[i + 1][0];
        }
        double res = Math.abs(sumA - sumB) / 2.0;
        System.out.printf("%.1f", res);
    }
}

// G5 다각형의 면적 수학 | 기하학
// 여러개 작업해보니까 가장 외쪽에 있는 큰 직사각형에서 직각 삼각형을 빼는 거처럼
// 신발끈 공식을 통해서 2차원 배열을 형태로 입력받고 가장 앞에 있는거를 맨뒤로 해서 연산식을 세운다음
// 누적 Absolute 값으로 처리하고 2.0으로 나눠서 1의자리까지 출력하게 끔 만들었다