package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (maxHeap.isEmpty() || maxHeap.peek() > num) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                if (minHeap.size() > N) {
                    maxHeap.offer(minHeap.poll());
                } else if (minHeap.size() < N) {
                    minHeap.offer(maxHeap.poll());
                }
            }
        }
        System.out.println(minHeap.peek());
    }
}

// S3 N번째 큰수 우선순위 큐
// 일단 우선순위 큐를 통해서 최대힙 최소힙을 구성한다
// N번째 큰수이기에 최소힙을 N개로 제한을 하고 나머지는 최대힙에 넣고 최소힙의 개수가 부족할 경우와
// 최소힙의 개수가 클 경우에 대해서 비교한다.