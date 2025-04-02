package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 부분합의 개수
        int sizeA = (n + 1) * n / 2;
        int[] sumA = new int[sizeA];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA[idx++] = sum;
            }
        }
        Arrays.sort(sumA);

        int sizeB = (m + 1) * m / 2;
        int[] sumB = new int[sizeB];
        idx = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB[idx++] = sum;
            }
        }
        Arrays.sort(sumB);

        System.out.println(two(sumA, sumB, T));
    }

    private static long two(int[] arr, int[] brr, int x) {
        int lo = 0;
        int hi = brr.length - 1;
        long cnt = 0;

        while (lo < arr.length && hi > -1) {
            int sum = arr[lo] + brr[hi];

            if (sum == x) {
                long sumLo = 1, sumHi = 1;
                while (lo + 1 < arr.length && arr[lo] == arr[lo + 1]) {
                    sumLo++;
                    lo++;
                }
                while (hi - 1 >= 0 && brr[hi] == brr[hi - 1]) {
                    sumHi++;
                    hi--;
                }
                cnt += sumLo * sumHi;
                lo++;
                hi--;
            } else if (sum > x) {
                hi--;
            } else {
                lo++;
            }
        }
        return cnt;
    }
}

// G3 두 배열의 합 투 포인터
// 진짜 어이없게 어렵고 문제가 이해가 안됐다.
// 일단 배열의 합에 대해서는 n* n+1 /2 의 개수가 만들어지기 때문에 n의 시간복잡도를 따져서 완전탐색으로
// 부분합을 가지는 배열을 만들었고 이렇게 2개의 부분합 배열에 있어서 투 포인터로 비교한다.
// 투 포인터는 보통 탈출 조건을 lo < hi 인데 이거는
// 2개의 배열을 비교하기 때문에 lo 는 arr 길이 -1 , hi는 0까지 가능하니까 이를 while 조건을 걸고
// 같은 숫자가 나오면 계속해서 탐색해서 누적합으로 곱을 해줘서 빼준다.