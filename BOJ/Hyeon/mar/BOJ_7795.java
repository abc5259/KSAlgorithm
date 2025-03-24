package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += lowerBound(B, A[i]);
            }
            sb.append(cnt).append("\n");
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
}

// S3 먹을 것인가 먹힐 것인가 이분탐색
// A보다 작은 B의 개수를 구한다. 이는 lowerBound를 통해서 인덱스를 확인하면 된다
// 만약 A가 8 1 7 3 1 일 때 B는 1 3 6 이다. 그럼 8이라는 값을 찾을 때는 6보다 크기 떄문에 lo가 6을 가리키고
// hi는 기존의 arr.length 를 가리킨다. 그래서 arr.length 인덱스는 3이므로 1 3 6보다 크기에 3이라는 개수를 반환한다고 생각하면된다.