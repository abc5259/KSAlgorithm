package BOJ.Hyeon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 최소 힙 (오른쪽 부분 - 중앙값보다 큰 값 저장)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙 (왼쪽 부분 - 중앙값 포함, 내림차순 정렬)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (maxHeap.isEmpty() || maxHeap.peek() > num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // 중앙값 출력 (maxHeap의 루트 값)
            sb.append(maxHeap.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

// G2 가운데를 말해요 최대 힙 최소 힙
// 중간 값을 구하는것인데 이를 위해 우선순위큐를 만들어서
// 중간값을 포함하는 최대 힙과, 중간값을 넘어가는 최소힙을 구한다
// 노드형식으로 생각하여 중간 값이 맨 루트 노드이고 그보다 작은 노드를 가지는 최대힙과
// 중간값을 벗어난 숫자를 통해 중간값과 가장 가가운 숫자가 루트 노드인 최소힙이있다.
// 사이즈를 통해서 구별하고, 그전에 max가 비어있으면 바로 최대힙에부터 넣고
// 만약 넣고자 하는 수가 최대힙의 노드보다 작으면 최대힙에 넣는다 그리고

// 사이즈 계산을 통해서 최대힙의 수를 최소힙으로 보내버린다.
// 근데 사이즈가 최소힙이 더 클경우 최대힙으로 보내서 중간값으로 사용한다.