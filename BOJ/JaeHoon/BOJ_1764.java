package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        // 11:33
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i=0; i<N+M; i++) {
            String s = br.readLine();
            if(set.contains(s)) {
                pq.offer(s);
                continue;
            }
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append('\n');
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append('\n');
        }
        System.out.print(sb);
    }
}
