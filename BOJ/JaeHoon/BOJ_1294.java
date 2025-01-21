package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if(a.startsWith(b) || b.startsWith(a)) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        for(int i=0; i<N; i++) {
            pq.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            String curr = pq.poll();
            sb.append(curr.charAt(0));
            String substring = curr.substring(1);
            if(!substring.isEmpty()) pq.offer(substring);
        }
        System.out.println(sb);
    }
}
