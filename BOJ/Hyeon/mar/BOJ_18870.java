package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] og = new int[N];
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            og[i] = Integer.parseInt(st.nextToken());
            set.add(og[i]);
        }

        int[] sorted = new int[set.size()];
        int idx = 0;
        for (int value : set) {
            sorted[idx++] = value;
        }
        Arrays.sort(sorted);

        for (int i = 0; i < N; i++) {
            sb.append(LowerBound(sorted, og[i])).append(" ");
        }
        System.out.println(sb);
    }

    private static int LowerBound(int[] arr, int x) {
        int lo = -1;
        int hi = arr.length - 1;

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
}

// S2 좌표 압축 정렬
// 내가 푼 풀이보다 이게 더 나은거 같음..