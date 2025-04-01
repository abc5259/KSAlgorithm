package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            int M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2).append("\n");

            int cnt = 0;

            while (M > 0) {
                if (M > 10) {
                    M -= 10;
                    cnt = 10;
                } else {
                    cnt = M;
                    M = 0;
                }

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < cnt; i++) {
                    int num = Integer.parseInt(st.nextToken());
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

                    if (i % 2 == 0) {
                        sb.append(maxHeap.peek()).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

// G2 중앙값 구하기 우선순위 큐
// 최대힙, 최소힙을 통해서 중간값을 구한다.
// 이때 출력문이 까다로웠는데 그냥 문제가 이상한거고
// M값이 10개가 넘어가면 입력을 이어서 못받아서 이를 위한 반복문을 한개 더 만들었다.
// M이 0보다 클때까지 반복하는 루프에다가 사용했다.
// 만약 최소힙의 크기가 최대힙보다 커지면 값을 이동하고, 최대힙의 크기가 최소힙보다 2개더많은경우 최소힙으로 이동한다.