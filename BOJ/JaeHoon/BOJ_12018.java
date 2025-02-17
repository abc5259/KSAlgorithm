package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] arr = new int[P];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<P; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            if(P < L) {
                pq.offer(1);
            } else {
                Arrays.sort(arr);
                pq.offer(arr[P-L]);
            }
        }

        int cnt = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            if(sum + pq.peek() <= M) {
                sum += pq.poll();
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
