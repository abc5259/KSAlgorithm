package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    maxPq.offer(n);
                    minPq.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else if (command == 'D') {
                    if(n == 1) { // 최댓값 삭제
                        while (!maxPq.isEmpty() && map.get(maxPq.peek()) <= 0) {
                            maxPq.poll();
                        }
                        if(maxPq.isEmpty()) {
                            continue;
                        }
                        int removeValue = maxPq.poll();
                        map.put(removeValue, map.get(removeValue) - 1);
                    }else {
                        while (!minPq.isEmpty() && map.get(minPq.peek()) <= 0) {
                            minPq.poll();
                        }
                        if(minPq.isEmpty()) {
                            continue;
                        }
                        int removeValue = minPq.poll();
                        map.put(removeValue, map.get(removeValue) - 1);
                    }
                }
            }

            while (!maxPq.isEmpty() && map.get(maxPq.peek()) <= 0) {
                maxPq.poll();
            }
            if(maxPq.isEmpty()) {
                sb.append("EMPTY\n");
                continue;
            }
            int removeMaxValue = maxPq.poll();
            while (!minPq.isEmpty() && map.get(minPq.peek()) <= 0) {
                minPq.poll();
            }
            if(minPq.isEmpty()) {
                continue;
            }
            int removeMinValue = minPq.poll();
            sb.append(removeMaxValue + " " + removeMinValue).append('\n');
        }
        System.out.print(sb);
    }
}
