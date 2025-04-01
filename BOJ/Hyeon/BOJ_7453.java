package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int[] CD = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                CD[idx++] = C[i] + D[j];
            }
        }
        Arrays.sort(CD);

        long cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int AB = A[i] + B[j];
                cnt += upperBound(CD, -AB) - lowerBound(CD, -AB);
            }
        }
        System.out.println(cnt);
    }

    private static int lowerBound(int[] arr, int x) {
        int lo = -1;
        int hi = arr.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    private static int upperBound(int[] arr, int x) {
        int lo = -1;
        int hi = arr.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}

// G2 합이 0인 네 정수 이분탐색, 중간에서 만나기 meet in the middle
// 입력값 n이 4000인데 4개의 정수를 합해서 0이 되는것을 따지는 경우의 수는 n^4 시간 복잡도 이다
// 이를 해결하기 위해 중간에서 만나기를 통해서 n^2 + n^2 처럼 연산한다.
// 배열을 정렬할 때 N^2*logN의 시간복잡도를 가지고
// n^2이 16000000이기 때문에 각 A+B의 결과가 16000000개 씩 생긴다면 n^4의 결과가 생기기 때문에 long으로 개수를 센다
// lowerBound와 upperBound를 통해서 해당 -A-B의 결과에 해당하는 수의 개수를 누적해서 더한다.