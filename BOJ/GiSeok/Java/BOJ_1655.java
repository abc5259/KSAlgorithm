// 우선순위 큐 - boj.kr/1655 가운데를 말해요
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (minHeap.size() == maxHeap.size())
                maxHeap.add(num);
            else
                minHeap.add(num);

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int swap = minHeap.remove();
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(swap);
                }
            }
            
            bw.write(maxHeap.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}