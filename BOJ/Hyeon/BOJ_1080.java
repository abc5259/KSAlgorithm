package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = 0;

        if (N >= 3 && M >= 3) {
            for (int i = 0; i <= N - 3; i++) {
                for (int j = 0; j <= M - 3; j++) {
                    if (A[i][j] != B[i][j]) {
                        flip(A, i, j);
                        cnt++;
                    }
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void flip(int[][] A, int row, int col) {
        for (int i = row; i < 3 + row; i++) {
            for (int j = col; j < 3 + col; j++) {
                A[i][j] ^= 1;
            }
        }
    }
}
// S1 행렬 그리디
// 일단 주어진 대로 탐욕을 고려한 채로 계속해서 했다.
// 1. 띄워쓰기가 없어서 StringTokenizer 를 쓰지않고 toCharArray를 썻는데 그냥 String 으로 받고 chatAt이 나았따.
// 2. N과 M이 항상 3 X 3 행렬로 검사해야되기 때문에 < N-2, < M-2 로 했는데 <=N-3 으로 가독성 높였고
// 그리고 그냥 조건문을 걸었다 왜냐하면 if로 N과 M이 3보다 크거나 같을때만 반복문 진입시켰다.
// 아니면 그냥 -1 출력하면되니까
// 그래서 flip 메소드에서 M을 검사할 필요없었다.
// 3. flip 에서는 row 와 col 만큼 더해서 연산하고 여기서 ^= 으로 exclusive 연산으로 단축시켰다.