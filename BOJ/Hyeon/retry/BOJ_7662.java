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
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    minHeap.offer(n);
                    maxHeap.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (n == 1) {
                        deleteValue(maxHeap);
                    } else {
                        deleteValue(minHeap);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int res = deleteValue(maxHeap);
                sb.append(res).append(" ");
                if (!map.isEmpty()) {
                    res = deleteValue(minHeap);
                }
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int deleteValue(PriorityQueue<Integer> heap) {
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

// G4 이중 우선순위 큐 우선순위큐
// 두개의 최소힙 최대힙 우선순위 큐가 있을 때.
// 최소값을 빼는 D와 최대값을 빼는 D를 하지만, 각각의 힙에는 영향을 주지않는다.
// 단순히 최대힙에서 빼버리면 최소힙은 변경되지않고, 반대도 마찬가지여서
// 동시에 값을 관리할 수 있는 map을 만든다.
// map의 키값은 숫자이고 숫자가 여러개 생길경우 +1씩해준다.
// 뺄때는 -1씩해주고 1이면 맵에서 제거해버린다.
// 반환값을 int로 받아서 max값과 min 값을 사용하면된다.