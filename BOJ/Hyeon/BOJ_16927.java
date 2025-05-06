package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R에 대해서 mod 연산으로 시간복잡도 줄이기

        int layer = Math.min(M, N) / 2;

        for (int i = 0; i < layer; i++) {
            int h = N - i * 2;
            int w = M - i * 2;

            int len = R % ((h + w) * 2 - 4);

            for (int j = 0; j < len; j++) {
                int tmp = arr[i][i];

                // 상단
                for (int col = 1 + i; col < M - i; col++) {
                    arr[i][col - 1] = arr[i][col];
                }

                // 우측
                for (int row = 1 + i; row < N - i; row++) {
                    arr[row - 1][M - 1 - i] = arr[row][M - 1 - i];
                }

                for (int col = M - 2 - i; col >= i; col--) {
                    arr[N - i - 1][col + 1] = arr[N - i - 1][col];
                }

                for (int row = N - 2 - i; row > i; row--) {
                    arr[row + 1][i] = arr[row][i];
                }
                arr[i + 1][i] = tmp;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

// G5 배열 돌리기2 회전, 브루트포스
// 배열 돌리기1 과 다른점은 R의 범위이다 R이 10억이기 때문에 mod 연산을 통해서 횟수를 줄여준다.
// 회전에 있어서 갯수마다 반복되기 떄문에 R % layer의 갯수만큼 나눠서 반복하면된다.
// N과 M 의 합 * 2- 4 개의 개수만큼 반복돼서 나눠주고 다음 차례의 계층도 -8씩해줘서 계산하면 된다.

// 둘레의 갯수가 -8씩 되기 때문에 이를 맞춰서 계산해주면되고
// 층별로 회전을 한다고 생각해서 가장 바깥층부터 N번 회전하면 층 * N번으로 시간복잡도를 계산하면된다.
// 반시계 방향으로 덮여 쓰여지기 때문에 0,0 1,1 과 같은 시작값을 저장해두고 상단은 오른쪽에서 왼쪽으로
// 우측은 아래에서 위로, 하단은 왼쪽에서 오른쪽으로 좌측은 위에서 아래로 값을 넣어주면된다.