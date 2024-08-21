/**
 * 14888 - 연산자 끼워넣기 [성공|00:45:55]
 * 실버1, 완전탐색, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {
    // 시간제한 2초, 메모리제한 512MB
    // 2 <= N <= 11 이기때문에 4개의 연산자를 완탐
    // 4^11 = 약 400만?
    // 그런데 연산자 갯수가 제한되어 있다. 그럼 최대 연산자 10개 중 10개를 뽑는 경우의 수를 구하고,
    // 그것마다 계산 N
    // 11 * 3628800 = 약 4천만..? 될듯

    // 0 == +, 1 == -, 2 == *, 3 == /

    static int N;
    static int[] A;
    static int[] idx;

    static int maxret = Integer.MIN_VALUE;
    static int minret = Integer.MAX_VALUE;

    static void swap(int idx1, int idx2) {
        int tmp = idx[idx1];
        idx[idx1] = idx[idx2];
        idx[idx2] = tmp;
    }

    static void permutation(int start) {
        int num1 = A[0];
        for (int i = 0; i < N-1; i++) {
            int num2 = A[i+1];

            if (idx[i] == 0) {
                num1 += num2;
            } else if (idx[i] == 1) {
                num1 -= num2;
            } else if (idx[i] == 2) {
                num1 *= num2;
            } else {
                num1 /= num2;
            }
        }

        maxret = Math.max(maxret, num1);
        minret = Math.min(minret, num1);

        for (int i = start; i < N-1; i++) {
            swap(i, start);
            permutation(start + 1);
            swap(i, start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        idx = new int[N-1];
        int s = 0;
        for (int i = 0; i < 4; i++) {
            int end = Integer.parseInt(st.nextToken());
            for (int j = 0; j < end; j++) idx[s++] = i;
        }

        permutation(0);
        System.out.println(maxret);
        System.out.println(minret);
    }
}
