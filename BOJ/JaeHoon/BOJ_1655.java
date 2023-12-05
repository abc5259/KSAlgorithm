package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> leftPQ = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            leftPQ.offer(arr[i]);

            if(leftPQ.size() - rightPQ.size() > 1) {
                rightPQ.offer(leftPQ.poll());
            }

            if(!rightPQ.isEmpty() && !leftPQ.isEmpty() &&
                    leftPQ.peek() > rightPQ.peek()) {
                rightPQ.offer(leftPQ.poll());
            }

            if(rightPQ.size() > leftPQ.size()) {
                leftPQ.offer(rightPQ.poll());
            }

            sb.append(leftPQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
