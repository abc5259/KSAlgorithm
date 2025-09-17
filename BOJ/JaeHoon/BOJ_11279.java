package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int v = Integer.parseInt(br.readLine());
            if(v == 0) {
                if(pq.size() == 0) {
                    sb.append("0").append('\n');
                }else {
                    sb.append(pq.poll()).append("\n");
                }
            }else {
                pq.offer(v);
            }
        }
        System.out.print(sb);
    }
}
