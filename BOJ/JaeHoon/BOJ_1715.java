package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            pq.add(arr[i]);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if(pq.isEmpty()) {
                break;
            }
            int b = pq.poll();
            sum += a+b;
            pq.offer(a + b);
        }
        System.out.println(sum);
    }
}
