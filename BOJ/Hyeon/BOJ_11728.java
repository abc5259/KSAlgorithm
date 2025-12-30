package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11728 {
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

        int i1 = 0, i2 = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 < N && i2 < M) {
            if (A[i1] < B[i2]) {
                sb.append(A[i1++]);
            } else {
                sb.append(B[i2++]);
            }
            sb.append(" ");
        }
        while (i1 < N) {
            sb.append(A[i1++]).append(" ");
        }
        while (i2 < M) {
            sb.append(B[i2++]).append(" ");
        }
        System.out.println(sb);
    }
}
// S5 배열 합치기 정렬
// 3분
// 원소의 개수는 N+ M == K 일때
// Arrays.sort는 KlogK이고 PQ도 삽입이 logK 추출이 logK여서 KlogK로 같다.
// 하지만 이미 정렬된 A 와 B 이기에
// PQ 는 K log K 이지만
// O(K) 로도 풀 수 있다고 생각 투 포인터로 while 조건걸어서 풀었다.