package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1791 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        int maxDeadLine = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cnt =  Integer.parseInt(st.nextToken());

            maxDeadLine = Math.max(maxDeadLine, deadline);
            if(map.containsKey(deadline)) {
                map.get(deadline).add(cnt);
            }else {
                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
                pq.offer(cnt);
                map.put(deadline, pq);
            }
        }

        int addCnt = 0;
        int deadLine = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        while (deadLine <= maxDeadLine) {
            if(map.containsKey(deadLine)) {

                pq.add(map.get(deadLine).poll());

                int last = addCnt;
                for(int i=1; i<=last; i++) {
                    if(map.get(deadLine).isEmpty()) break;
                    pq.add(map.get(deadLine).poll());
                    addCnt--;
                }

                while (!map.get(deadLine).isEmpty() &&
                        !pq.isEmpty() &&
                        map.get(deadLine).peek() > pq.peek()) {
                    pq.poll();
                    pq.add(map.get(deadLine).poll());
                }
            }
            else {
                addCnt++;
            }

            deadLine++;

        }

        long sum = 0;
        while (!pq.isEmpty()) {
            int cnt = pq.poll();
            sum += cnt;
        }

        System.out.println(sum);

    }
}