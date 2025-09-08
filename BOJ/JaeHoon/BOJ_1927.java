package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int item = Integer.parseInt(br.readLine());
            if(item == 0) {
                if(pq.size() == 0) {
                    sb.append(0).append('\n');
                }else {
                    sb.append(pq.poll()).append('\n');
                }
            }else {
                pq.offer(item);
            }
        }

        System.out.print(sb);
    }
}
