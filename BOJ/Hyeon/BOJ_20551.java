package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            int D = Integer.parseInt(br.readLine());
            sb.append(lowerBound(A, D)).append("\n");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] B, int d) {
        int lo = -1;
        int hi = B.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (B[mid] >= d) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return (hi < B.length && B[hi] == d) ? hi : -1;
    }
}

// S4 Sort 마스터 배지훈의 후계자 이분탐색
// 일단 구하고자 하는 값이 경계값에서 해당 값이 있는지 그렇다면 그 인덱스는 무엇인지 인데
// 그러면 그 값을 lowerBound 를 통해서 처음으로 그값과 일치하는 것을 찾아 인덱스를 반환한다.
// lowerBound 는 배열[mid] 값이 >= 타겟이면 hi를 줄여나가야하고
// 배열[mid] < 타겟이면 lo를 올려야 된다.