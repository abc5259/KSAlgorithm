package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, x) - lowerBound(arr, x)).append(" ");
        }
        System.out.println(sb);
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
// S4 숫자 카드2 이분탐색
// LowerBound, UpperBound 에 대한 학습 필요 이분 탐색 생각 더 해보자.