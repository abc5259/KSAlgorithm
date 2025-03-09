package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<int[]> dq = new ArrayDeque<>();
        int[] A = new int[N];
        int[] D = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            while (!dq.isEmpty() && dq.peekLast()[0] > A[i]) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{A[i], i});
            while (!dq.isEmpty() && dq.peekFirst()[1] <= i - L) {
                dq.pollFirst();
            }
            D[i] = dq.peekFirst()[0];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(D[i] + " ");
        }
        System.out.println(sb);
    }
}
