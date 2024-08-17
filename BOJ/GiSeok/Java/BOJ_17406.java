/**
 * 17406 - 배열 돌리기 4 [성공(반례힌트)|01:06:16]
 * 골드4, 구현/완전탐색, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17406 {
    // 시간제한 1초, 메모리제한 512MB
    // 크기 N*M인 배열 A
    // 배열 A의 값 == 각 행에 있는 모든 수의 합 중 최솟값
    // 1 2 3
    // 2 1 1
    // 4 5 6
    // 배열 A의 값 = 4
    // 회전 연산 가능 (r,c,s)
    // 가장 왼쪽 윗 칸 (r-s, c-s)
    // 가장 오른쪽 아래 칸 (r+s, c+s)
    // 배열 A와 회전 연산이 주어지면 회전 연산을 모두 한 번씩 사용해서 나오는 배열 A 값의 최솟값을 구하자.
    // 3 <= N, M <= 50

    // 왼쪽 위, 오른쪽 아래 좌표 대각선 안으로 이동 -> 둘의 좌표가 같아지면 회전 stop!!

    static int[][] A;
    static int[][] rcs;
    static int[] idxlist;
    static int N, M, K;
    static int ret = Integer.MAX_VALUE;

    static void swap(int idx1, int idx2) {
        int tmp = idxlist[idx1];
        idxlist[idx1] = idxlist[idx2];
        idxlist[idx2] = tmp;
    }

    static void permutation(int r) {
        if (r == K) {
            int[][] m = new int[N][M];
            for (int i = 0; i < N; i++)
                m[i] = A[i].clone();

            // 회전 연산 수행 후 최솟값 갱신
            for (int i = 0; i < K; i++) {
                int y1 = rcs[idxlist[i]][0] - rcs[idxlist[i]][2];
                int x1 = rcs[idxlist[i]][1] - rcs[idxlist[i]][2];

                int y2 = rcs[idxlist[i]][0] + rcs[idxlist[i]][2];
                int x2 = rcs[idxlist[i]][1] + rcs[idxlist[i]][2];

                while (y1 != y2 || x1 != x2) {
                    int tmp = m[y1][x1];

                    for (int y = y1 + 1; y <= y2; y++)
                        m[y-1][x1] = m[y][x1];
                    for (int x = x1 + 1; x <= x2; x++)
                        m[y2][x-1] = m[y2][x];
                    for (int y = y2 - 1; y >= y1; y--)
                        m[y+1][x2] = m[y][x2];
                    for (int x = x2 - 1; x > x1; x--) {
                        m[y1][x+1] = m[y1][x];
                        if (x == x1+1) m[y1][x] = tmp;
                    }

                    y1++;
                    x1++;
                    y2--;
                    x2--;
                }
            }

            for (int y = 0; y < N; y++) {
                int sum = 0;
                for (int x = 0; x < M; x++) {
                    sum += m[y][x];
                }

                ret = Math.min(sum, ret);
            }
            return;
        }

        for (int i = r; i < K; i++) {
            swap(i, r);
            permutation(r + 1);
            swap(i, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rcs = new int[K][3];
        idxlist = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            rcs[i][0] = Integer.parseInt(st.nextToken())-1;
            rcs[i][1] = Integer.parseInt(st.nextToken())-1;
            rcs[i][2] = Integer.parseInt(st.nextToken());
            idxlist[i] = i;
        }

        permutation(0);
        System.out.println(ret);
    }
}