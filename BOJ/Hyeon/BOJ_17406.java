package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] spin = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            spin[i] = new int[]{r, c, s};
        }

        int[] orders = new int[K];
        for (int i = 0; i < K; i++) {
            orders[i] = i;
        }
        // 순열을 위한 순서있는 숫자 조합

        int min = Integer.MAX_VALUE;


        do {
            int[][] tmp = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, tmp[i], 0, M);
            }

            for (int i = 0; i < K; i++) {
                int idx = orders[i];
                rotate(tmp, spin[idx][0], spin[idx][1], spin[idx][2]);
            }
            min = Math.min(min, sum(tmp));
        } while (next_perm(orders));

        System.out.print(min);
    }

    static boolean next_perm(int[] orders) {
        int left = orders.length - 1;
        while (left > 0 && orders[left - 1] > orders[left]) {
            left--;
        }
        if (left == 0) {
            return false;
        }
        int right = orders.length - 1;
        while (orders[left - 1] > orders[right]) {
            right--;
        }
        swap(left - 1, right, orders);

        right = orders.length - 1;
        while (left < right) {
            swap(left, right, orders);
            left++;
            right--;
        }
        return true;
    }

    static void swap(int a, int b, int[] orders) {
        int tmp = orders[a];
        orders[a] = orders[b];
        orders[b] = tmp;
    }

    static void rotate(int[][] tmp, int r, int c, int s) {

        for (int i = s; i > 0; i--) {
            int tmpVal = tmp[r - i][c - i];

            // 좌측
            for (int row = r - i; row < r + i; row++) {
                tmp[row][c - i] = tmp[row + 1][c - i];
            }
            // 하단
            for (int col = c - i; col < c + i; col++) {
                tmp[r + i][col] = tmp[r + i][col + 1];
            }

            // 우측
            for (int row = r + i; row > r - i; row--) {
                tmp[row][c + i] = tmp[row - 1][c + i];
            }

            // 상단
            for (int col = c + i; col > c - i; col--) {
                tmp[r - i][col] = tmp[r - i][col - 1];
            }
            tmp[r - i][c - i + 1] = tmpVal;
        }
    }

    static int sum(int[][] arr) {
        int min = Integer.MAX_VALUE;

        for (int[] ints : arr) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}

// G4 배열 돌리기 4 순열 브루트포스 시뮬레이션
// 준나 어려워 어떻게 그냥 이것저것 구현하다보니 끝났네
// spin 이랑 order 관련해서 복습 필요