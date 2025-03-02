package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2696 {
    static StringTokenizer st;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2).append("\n");
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            while (M > 0) {
                if (M > 10) {
                    cnt = 10;
                    M = M - 10;
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
