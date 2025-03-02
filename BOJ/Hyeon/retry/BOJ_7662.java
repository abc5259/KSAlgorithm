package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7662 {
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("I")) {
                    int n = Integer.parseInt(st.nextToken());
                    minHeap.offer(n);
                    maxHeap.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    int n = Integer.parseInt(st.nextToken());
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (n == 1) {
                        deleteValid(maxHeap);
                    } else {
                        deleteValid(minHeap);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int max = deleteValid(maxHeap);
                sb.append(max).append(" ");
                if (!map.isEmpty()) {
                    int min = deleteValid(minHeap);
                    sb.append(min).append("\n");
                } else {
                    sb.append(max).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int deleteValid(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
                return heap.poll();
            } else {
                heap.poll();
            }
        }
        return 0;
    }
}

// G4 이중 우선순위 큐 우선순위 큐
// 2개의 힙으로 구성했는데 동시에 지워져야돼서 map을 사용?
// retry