package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2776 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());


            for (int i = 0; i < M; i++) {
                int var = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(var)).append("\n");
            }
            System.out.println(sb);
        }
    }

    static int binarySearch(int var) {
        int lo = 0;
        int hi = N - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (arr[mid] <= var) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (arr[lo] == var || arr[hi] == var) {
            return 1;
        }
        return 0;
    }
}
