package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int res = 0;

        for (int i = 0; i < N; i++) {
            int len = br.readLine().length();
            while (!queue.isEmpty() && i - queue.peek()[0] > K) {
                queue.poll();
            }
            for (int[] ints : queue) {
                if (ints[1] == len) {
                    res++;
                }
            }
            queue.offer(new int[]{i, len});
        }
        System.out.println(res);
    }
}
// 시간 초과