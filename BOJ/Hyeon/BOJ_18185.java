package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long totalCost = 0;

        for (int i = 0; i < N; i++) {
            if (A[i + 1] > A[i + 2]) {
                int buyTwo = Math.min(A[i], A[i + 1] - A[i + 2]);
                A[i] -= buyTwo;
                A[i + 1] -= buyTwo;
                totalCost += buyTwo * 5L;

            }
            int buyThree = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
            A[i] -= buyThree;
            A[i + 1] -= buyThree;
            A[i + 2] -= buyThree;
            totalCost += buyThree * 7L;

            int buyTwo = Math.min(A[i], A[i + 1]);
            A[i] -= buyTwo;
            A[i + 1] -= buyTwo;
            totalCost += buyTwo * 5L;

            totalCost += A[i] * 3L;
        }
        System.out.println(totalCost);
    }
}
// D5 라면 사기 (Small) 그리디
// 1시간
// 답지 보고 풀었다. 백준 서버 종료 기념 다이아.