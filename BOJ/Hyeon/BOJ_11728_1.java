package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

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
        StringBuilder sb = new StringBuilder();

        int aIdx = 0, bIdx = 0;
        while (aIdx != N && bIdx != M) {
            if (A[aIdx] > B[bIdx]) {
                sb.append(B[bIdx++]);
            } else {
                sb.append(A[aIdx++]);
            }
            sb.append(" ");
        }

        if (aIdx == N) {
            for (int i = bIdx; i < M; i++) {
                sb.append(B[i]).append(" ");
            }
        } else {
            for (int i = aIdx; i < N; i++) {
                sb.append(A[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
// S5 배열 합치기 투 포인터
// 5분
// 일단 나는 A 랑 B가 정렬되지 않은건줄 알고 당연히 리스트로 했는데
// 둘다 정렬되었다면 O(N+M) 로 가능한 투 포인터로 한쪽을 다 보낸다음 만약 남아있다면 그거만 반복문으로 처리하게 한다.