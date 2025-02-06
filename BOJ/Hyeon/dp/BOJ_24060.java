package BOJ.Hyeon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060 {
    static int K;
    static int cnt;
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(A);
        System.out.println(res);
    }

    static int[] sorted;

    static void merge_sort(int[] a) {
        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    private static void merge_sort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(a, left, mid);
            merge_sort(a, mid + 1, right);

            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        if (l > mid) {
            while (r <= right) {
                sorted[idx] = a[r];
                r++;
                idx++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = a[l];
                l++;
                idx++;
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
            cnt++;
            if (cnt == K) {
                res = a[i];
                break;
            }
        }
    }
}
