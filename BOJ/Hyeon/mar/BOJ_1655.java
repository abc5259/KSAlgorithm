package BOJ.Hyeon.mar;

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

            // Step 1: minHeap에 먼저 넣기
            minHeap.offer(num);

            // Step 2: minHeap의 최솟값을 maxHeap으로 이동 (중앙값을 maxHeap이 유지해야 함)
            maxHeap.offer(minHeap.poll());

            // Step 3: 크기 조정 (maxHeap이 항상 크거나 같아야 함)
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }

            // 중앙값 출력 (maxHeap의 루트 값)
            sb.append(maxHeap.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}